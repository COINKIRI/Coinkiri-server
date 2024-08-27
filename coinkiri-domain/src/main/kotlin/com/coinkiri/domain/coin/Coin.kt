package com.coinkiri.domain.coin

import java.time.LocalDateTime

data class Coin(
    val marketName: String,
    val koreanName: String,
    val englishName: String,
    val symbol: ByteArray? = null,
    val createdAt: LocalDateTime
) {
    companion object {
        fun fromList(coinCreateList: List<CoinCreate>): List<Coin> {
            return coinCreateList.map { from(it) }
        }

        private fun from(coinCreate: CoinCreate) =
            Coin(
                marketName = coinCreate.marketName,
                koreanName = coinCreate.koreanName,
                englishName = coinCreate.englishName,
                createdAt = LocalDateTime.now(),
            )
    }
}
