package com.coinkiri.application.service.coin

import com.coinkiri.application.port.`in`.usecase.UpdateCoin
import com.coinkiri.application.port.out.jpa.CoinRepository
import com.coinkiri.domain.coin.Coin
import org.springframework.web.client.RestTemplate

class CoinUpdateService(
    private val coinRepository: CoinRepository,
    private val restTemplate: RestTemplate
) : UpdateCoin {

    override fun invoke(): List<Coin> {

    }
}
