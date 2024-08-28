package com.coinkiri.application.port.out.upbit

import com.coinkiri.domain.coin.CoinCreate

interface UpbitApiCaller {

    fun getCoinList(): List<CoinCreate>

    fun getCoinDetail(market: String)
}
