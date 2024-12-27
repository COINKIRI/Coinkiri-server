package com.coinkiri.application.port.out.jpa

import com.coinkiri.domain.coin.Coin

interface CoinRepository {

    fun saveAll(coinList: List<Coin>): List<Coin>

    fun findAll(): List<Coin>

    fun save(coin: Coin)
}
