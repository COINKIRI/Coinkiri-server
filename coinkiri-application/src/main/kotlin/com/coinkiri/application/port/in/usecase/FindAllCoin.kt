package com.coinkiri.application.port.`in`.usecase

import com.coinkiri.domain.coin.Coin

fun interface FindAllCoin {

    fun findAllCoin(): List<Coin>
}
