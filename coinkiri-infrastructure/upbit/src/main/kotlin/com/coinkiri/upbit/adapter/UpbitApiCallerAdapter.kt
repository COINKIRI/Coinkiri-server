package com.coinkiri.upbit.adapter

import com.coinkiri.application.port.out.dto.CoinDetailDto
import com.coinkiri.application.port.out.dto.CoinDto
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
            val response = restTemplate.getForObject(coinRequestUrl, Array<CoinDto>::class.java)

            val krwCoinCreateList = response.filter { it.market.startsWith("KRW-") }
                .map { CoinCreate(it.market, it.korean_name, it.english_name) }

            return krwCoinCreateList

        } catch (e: Exception) {
            log.error(e) { "Error fetching coin list" }
        }

        return emptyList()
    }

    override fun getCoinDetail(market: String) {
        val coinRequestUrl = "https://api.upbit.com/v1/candles/days?market=KRW-$market&count=200"

        try {
            val response = restTemplate.getForObject(coinRequestUrl, Array<CoinDetailDto>::class.java)

            log.info { response }


        } catch (e: Exception) {
            log.error(e) { "Error fetching coin detail" }
        }
    }
}
