package com.eram.ethcheckermvp.contract

interface ContractInterface {
    interface ViewI {
        fun initView()
        fun showProgress()
        fun hideProgress()
        fun initWallet(address: String)
        fun showAddressError()
    }

    interface ModelI {

    }

    interface PresenterI {
        fun getWallet(address: String)

    }
}