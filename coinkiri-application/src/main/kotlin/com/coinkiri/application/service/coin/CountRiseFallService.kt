package com.coinkiri.application.service.coin

import com.coinkiri.application.port.`in`.usecase.CountRiseFall
import com.coinkiri.application.port.out.upbit.UpbitApiCaller
import com.coinkiri.domain.coin.RiseFallCount
import org.springframework.stereotype.Service

@Service
class CountRiseFallService(
    private val upbitApiCaller: UpbitApiCaller
) : CountRiseFall {

    override fun countRiseAndFall(): RiseFallCount {
        TODO("Not yet implemented")
    }
}
