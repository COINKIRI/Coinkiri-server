package com.coinkiri.upbit.adapter

import com.coinkiri.application.port.out.dto.CoinDetailDto
import com.coinkiri.application.port.out.dto.CoinDto
import com.coinkiri.application.port.out.upbit.UpbitApiCaller
import com.coinkiri.common.log.Slf4JKotlinLogging.log
import com.coinkiri.domain.coin.CoinCreate
import com.coinkiri.domain.coin.CoinDetail
import com.coinkiri.domain.coin.Price
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
                ?: throw RuntimeException("Upbit API 응답이 null입니다.")

            val krwCoinCreateList = response.filter { it.market.startsWith("KRW-") }
                .map { CoinCreate(it.market, it.korean_name, it.english_name) }

            return krwCoinCreateList

        } catch (e: Exception) {
            log.error(e) { "Error fetching coin list" }
        }

        return emptyList()
    }

    override fun getCoinDetail(market: String): CoinDetail {
        val coinRequestUrl = "https://api.upbit.com/v1/candles/days?market=$market&count=200"

        try {
            val response = restTemplate.getForObject(coinRequestUrl, Array<CoinDetailDto>::class.java)
                ?: throw RuntimeException("Upbit API 응답이 null입니다.")

            return CoinDetail(
                market = market,
                prices = response.map { Price(it.candle_date_time_kst, it.trade_price.toLong()) }
            )
        } catch (e: Exception) {
            log.error(e) { "Error fetching coin detail" }
        }

        return CoinDetail(market, emptyList())
    }

    override fun isRiseOrFall(market: String): Boolean {
        val coinRequestUrl = "https://api.upbit.com/v1/candles/days?market=$market&count=1"

        try {
            val response = restTemplate.getForObject(coinRequestUrl, Array<CoinDetailDto>::class.java)
                ?: throw RuntimeException("Upbit API 응답이 null입니다.")
            
            log.info { "Coin detail: ${response.first().change_rate}" }
            return response.first().change_rate >= 0

        } catch (e: Exception) {
            log.error(e) { "Error fetching coin detail" }
            return false
        }
    }
}
