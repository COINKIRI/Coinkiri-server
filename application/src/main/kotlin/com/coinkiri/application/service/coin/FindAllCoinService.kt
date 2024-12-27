package com.coinkiri.application.service.coin

import com.coinkiri.application.port.`in`.usecase.FindAllCoin
import com.coinkiri.application.port.out.jpa.CoinRepository
import com.coinkiri.domain.coin.Coin
import org.springframework.stereotype.Service

@Service
class FindAllCoinService(
    private val coinRepository: CoinRepository
) : FindAllCoin {

    override fun findAllCoin(): List<Coin> {
        return coinRepository.findAll()
    }
}
