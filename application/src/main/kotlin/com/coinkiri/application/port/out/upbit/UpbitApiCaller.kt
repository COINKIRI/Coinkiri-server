package com.coinkiri.application.port.out.upbit

import com.coinkiri.domain.coin.CoinCreate
import com.coinkiri.domain.coin.CoinDetail
import com.coinkiri.domain.coin.RiseFallCount

interface UpbitApiCaller {

    fun getCoinList(): List<CoinCreate>

    fun getCoinDetail(market: String): CoinDetail

    fun getRiseAndFallCount(marketList: List<String>): RiseFallCount
}
