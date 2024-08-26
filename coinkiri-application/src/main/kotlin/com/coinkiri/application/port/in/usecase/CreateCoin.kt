package com.coinkiri.application.port.`in`.usecase

import com.coinkiri.domain.coin.Coin

fun interface CreateCoin {

    fun invoke(command: Command): Coin

    data class Command(
        val marketName: String,
        val koreanName: String,
        val englishName: String,
        val symbol: ByteArray
    )
}
