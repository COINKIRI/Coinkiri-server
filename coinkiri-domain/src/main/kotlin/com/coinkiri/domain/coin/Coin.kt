package com.coinkiri.domain.coin

import java.time.LocalDateTime

data class Coin(
    val marketName: String,
    val koreanName: String,
    val englishName: String,
    val symbol: ByteArray? = null,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    companion object {
        fun from(coinCreate: CoinCreate): Coin {
            return Coin(
                marketName = coinCreate.marketName,
                koreanName = coinCreate.koreanName,
                englishName = coinCreate.englishName,
                createdAt = LocalDateTime.now(),
                updatedAt = LocalDateTime.now()
            )
        }
    }
}
