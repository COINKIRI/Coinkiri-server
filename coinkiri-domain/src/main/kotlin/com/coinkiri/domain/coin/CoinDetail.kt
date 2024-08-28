package com.coinkiri.domain.coin

data class CoinDetail(
    val market: String,
    val prices: List<Price>
)
