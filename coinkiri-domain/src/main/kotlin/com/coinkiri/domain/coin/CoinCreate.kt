package com.coinkiri.domain.coin

data class CoinCreate(
    val marketName: String,
    val koreanName: String,
    val englishName: String,
    val symbol: ByteArray
)
