package com.coinkiri.application.service.coin

import com.coinkiri.application.port.`in`.usecase.CreateCoin
import com.coinkiri.domain.coin.Coin

class CoinCreateService(
    
) : CreateCoin {

    override fun invoke(command: CreateCoin.Command): Coin {
        TODO("Not yet implemented")
    }
}
