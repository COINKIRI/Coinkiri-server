package com.coinkiri.application.service.coin.scheduler

import com.coinkiri.application.port.out.jpa.CoinRepository
import com.coinkiri.application.port.out.upbit.UpbitApiCaller
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Service
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

@Service
class CoinFetchScheduler(
    private val coinRepository: CoinRepository,
    private val upbitApiCaller: UpbitApiCaller
) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {

        val scheduler = Executors.newSingleThreadScheduledExecutor();

        scheduler.scheduleAtFixedRate({
            val coinCreateList = upbitApiCaller.getCoinList()
        }, 2, 3600 * 60, TimeUnit.SECONDS) // 2초 후부터 하루에 한 번 실행
    }
}
