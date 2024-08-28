package com.coinkiri.application.port.`in`.usecase

import com.coinkiri.domain.coin.CoinDetail

fun interface GetCoinDetail {

    fun getCoinDetail(market: String): CoinDetail
}
