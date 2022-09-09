package com.eram.ethcheckermvp.view

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.eram.ethcheckermvp.contract.ContractInterface.ViewI
import com.eram.ethcheckermvp.contract.Wallet
import com.eram.ethcheckermvp.databinding.ActivityMainBinding
import com.eram.ethcheckermvp.view.ThreadUtil
import com.eram.ethcheckermvp.presenter.MainActivityPresenter
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import java.io.InputStream
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection


class MainActivity : AppCompatActivity(), ViewI {
    private var presenter: MainActivityPresenter? = null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        presenter = MainActivityPresenter(this)
        setContentView(binding.root)
    }

    override fun initView() {
        binding.buttonLookup.setOnClickListener { presenter?.getWallet(binding.editTextAddress.text.toString())}
//        binding.buttonLookup.setOnClickListener { presenter?.getWallet("0xab02283db695e9ae463db93ecae13ad0bb943592")}
    }

    override fun initWallet(address: String){
        showProgress()
        ThreadUtil.startThread{
            var wallet: Wallet? = null
            val apiEndpoint = URL("https://api.ethplorer.io/getAddressInfo/$address?apiKey=freekey")
            val myConnection: HttpsURLConnection =
                apiEndpoint.openConnection() as HttpsURLConnection
            if (myConnection.getResponseCode() == 200) {
                val responseBody: InputStream = myConnection.inputStream
                val responseBodyReader = InputStreamReader(responseBody, "UTF-8")
                val mapper = ObjectMapper()
                val rootNode: JsonNode = mapper.readTree(responseBodyReader)
                val balEth = rootNode["ETH"]["balance"].asDouble()
                val rate = rootNode["ETH"]["price"]["rate"].asDouble()
                val balUsd = balEth * rate
                val noOfTx = rootNode["countTxs"].asInt()
                wallet = Wallet(address, rate, balEth, balUsd, noOfTx)
            }
            ThreadUtil.startUIThread(0){
                if (wallet != null) {
                    val ethStr = "Balance (ETH): "+wallet.balanceETH.toString()
                    val usdStr = "Balance (USD): "+ String.format("%.4f",wallet.balanceUSD)
                    val txStr = "No of Transactions: "+wallet.noOfTransactions.toString()
                    binding.balanceEth.text = ethStr
                    binding.balanceUsd.text = usdStr
                    binding.noOfTx.text = txStr
                    hideProgress()
                } else{
                    showAddressError()
                }
            }
        }
    }

    override fun showProgress() {
        binding.progressBar.visibility = View.VISIBLE
        binding.buttonLookup.visibility = View.GONE
    }

    override fun hideProgress() {
        binding.progressBar.visibility = View.GONE
        binding.buttonLookup.visibility = View.VISIBLE
    }

    override fun showAddressError(){
        val msg = "Invalid ETH Wallet Address. Please try again.\n\nHint: ETH address is a 42 char long hexadecimal"
        val title = "Invalid Address"
        showAlertDialog(msg, title, "OK", true)
    }

    private fun showAlertDialog(message: String, title: String, buttonLabel: String, closeDialog: Boolean) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setMessage(message).setTitle(title)
        builder.setCancelable(false)
            .setNegativeButton(buttonLabel) { dialog, _ ->
                if (closeDialog) {
                    dialog.cancel()
                }
            }
        val alert: AlertDialog = builder.create()
        alert.setTitle(title)
        alert.show()
    }
}