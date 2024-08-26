package com.coinkiri.upbit.adapter

import com.coinkiri.application.port.out.dto.CoinInfo
import com.coinkiri.application.port.out.upbit.UpbitApiCaller
import com.coinkiri.common.log.Slf4JKotlinLogging.log
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class UpbitApiCallerAdapter(
    private val restTemplate: RestTemplate
) : UpbitApiCaller {

    override fun getCoinList() {
        val coinRequestUrl = "https://api.upbit.com/v1/market/all"

        val response = restTemplate.getForObject(coinRequestUrl, Array<CoinInfo>::class.java)
            ?: throw RuntimeException("Upbit API 응답이 null입니다.")

        log.info { "response: $response" }
    }
}
