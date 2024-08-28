package com.coinkiri.application.service.coin

import com.coinkiri.application.port.`in`.usecase.GetCoinDetail
import com.coinkiri.application.port.out.upbit.UpbitApiCaller
import com.coinkiri.domain.coin.CoinDetail
import org.springframework.stereotype.Service

@Service
class GetCoinDetailService(
    private val upbitApiCaller: UpbitApiCaller
) : GetCoinDetail {

    override fun getCoinDetail(market: String): CoinDetail {
        return upbitApiCaller.getCoinDetail(market)
    }
}
