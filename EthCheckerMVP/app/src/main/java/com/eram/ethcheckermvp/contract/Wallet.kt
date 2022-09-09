package com.eram.ethcheckermvp.contract

data class Wallet(
    val walletAddress: String,
    val rate: Double,
    val balanceETH: Double,
    val balanceUSD: Double,
    val noOfTransactions: Int
)
