package com.coinkiri.application.port.`in`.usecase

import com.coinkiri.domain.coin.Coin

fun interface UpdateCoin {

    fun invoke(): List<Coin>
}
