package com.coinkiri.application.port.out.dto

import com.coinkiri.domain.coin.CoinCreate

data class CoinDto(
    val market: String,
    val korean_name: String,
    val english_name: String
) {
    fun to() = CoinCreate(
        marketName = market,
        koreanName = korean_name,
        englishName = english_name
    )
}
