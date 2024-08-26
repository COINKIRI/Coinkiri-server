package com.coinkiri.application.service.coin

import com.coinkiri.application.port.out.jpa.CoinRepository
import com.coinkiri.application.port.out.upbit.UpbitApiCaller
import org.springframework.stereotype.Service

@Service
class CoinUpdateService(
    private val coinRepository: CoinRepository,
    private val upbitApiCaller: UpbitApiCaller
) {

    fun save() {

    }
}
