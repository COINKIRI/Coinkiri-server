package com.coinkiri.application.service.coin

import com.coinkiri.application.port.out.jpa.CoinRepository
import org.springframework.stereotype.Service

@Service
class CoinUpdateService(
    private val coinRepository: CoinRepository,
//    private val restTemplate: RestTemplate
) {

    fun save() {
        val upbitRequestUrl = "https://api.upbit.com/v1/market/all"

    }
}
