package com.coinkiri.application.service.coin

import com.coinkiri.application.port.`in`.usecase.CountRiseFall
import com.coinkiri.application.port.out.jpa.CoinRepository
import com.coinkiri.application.port.out.upbit.UpbitApiCaller
import com.coinkiri.domain.coin.RiseFallCount
import org.springframework.stereotype.Service

@Service
class CountRiseFallService(
    private val upbitApiCaller: UpbitApiCaller,
    private val coinRepository: CoinRepository
) : CountRiseFall {

    override fun countRiseAndFall(): RiseFallCount {

        val marketList = coinRepository.findAll().map { it.marketName }

        var riseCount = 0
        var fallCount = 0

        marketList.forEach {
            if (upbitApiCaller.isRiseOrFall(it)) {
                riseCount++
            } else {
                fallCount++
            }
            Thread.sleep(100)
        }

        return RiseFallCount(riseCount, fallCount)
    }
}
