package com.coinkiri.upbit.adapter

import com.coinkiri.application.port.out.dto.CoinResponse
import com.coinkiri.application.port.out.upbit.UpbitApiCaller
import com.coinkiri.common.log.Slf4JKotlinLogging.log
import com.coinkiri.domain.coin.CoinCreate
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class UpbitApiCallerAdapter(
    private val restTemplate: RestTemplate
) : UpbitApiCaller {

    override fun getCoinList(): List<CoinCreate> {
        val coinRequestUrl = "https://api.upbit.com/v1/market/all"

        try {
            val response = restTemplate.getForObject(coinRequestUrl, Array<CoinResponse>::class.java)
                ?: throw RuntimeException("Upbit API 응답이 null입니다.")

            log.info { "Response: ${response.joinToString(separator = ", ") { it.toString() }}" }

            return response.map { it.to() }

        } catch (e: Exception) {
            log.error(e) { "Error fetching coin list" }
        }
    }
}
