package com.eram.ethcheckermvp.presenter

import android.os.Looper
import com.eram.ethcheckermvp.contract.ContractInterface.*
import com.eram.ethcheckermvp.contract.Wallet
import com.eram.ethcheckermvp.model.MainActivityModel
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import java.io.InputStream
import java.io.InputStreamReader
import java.net.URL
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.net.ssl.HttpsURLConnection

class MainActivityPresenter(_view: ViewI): PresenterI {

    private var view: ViewI = _view
    private var model: ModelI = MainActivityModel()

    init {
        view.initView()
    }

    override fun getWallet(address: String) {
//        view.showProgress()

        if (address.length!=42 || !address.matches("0[xX][0-9a-fA-F]+".toRegex())){
            view.showAddressError()
        } else {
            view.initWallet(address)
        }
    }
}