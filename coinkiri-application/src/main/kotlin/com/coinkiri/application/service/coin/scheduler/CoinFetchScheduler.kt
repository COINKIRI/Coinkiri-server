package com.coinkiri.application.service.coin.scheduler

import com.coinkiri.application.port.out.jpa.CoinRepository
import com.coinkiri.application.port.out.upbit.UpbitApiCaller
import com.coinkiri.domain.coin.Coin
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

            fetchCoinList()

            fetchSymbolImage()
        }, 2, 3600 * 60, TimeUnit.SECONDS) // 2초 후부터 하루에 한 번 실행
    }

    private fun fetchCoinList() {
        val coinCreateList = upbitApiCaller.getCoinList()
        val coinList = Coin.fromList(coinCreateList)
        coinRepository.saveAll(coinList)
    }

    private fun fetchSymbolImage() {
        val coinList = coinRepository.findAll()
        coinList.forEach { coin ->
            if (coin.symbol == "iVBORw0KGgoAAAANSUhEUgAAACgAAAAoCAYAAACM/rhtAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAPaSURBVHgBzZhJSCNBFIb/ZMQFt7jggpcEXC+OouhBcOYoHlwubohkwIuiOHPTg2guXmeiKCLiBiqKMubgweXg4E085CJuaBJEYcAlrrhn6hUmZFO7M0nsDyrd9bq78vereq+qSwY3GAwGxd3dnVomk31h1SxWlPANRlb07H90qampI+5ukDkbtre3y9hhmBUF/IuRCdU4C5XbV3Z2dn6yw2/4XxyhtFgsw7u7ux32RpsH6cLz83MnJADz5C/myR/8nH6Y59SkHtKiPC0tbY4LZOPOAN8FgqeYAwMDVZ/Ie6yihvQIfnx8/CtnXVsK6fJVzgakEhKFaftMHsyCdFEGwAvc3t66tQcHB+N/8UjgxcUFRkdHsbS0BDYlIj4+ntu3trZwfn4Olh6gUChwdnZG3YSCggLU1tYiKSkJYpGxFGMR88DExASmp6dRX1+PwsJCREREOFwfGhrCzMwMpqamEB4ejpubGywsLGBychJqtRrFxcUQgyiBOp0O4+PjGBwcdBFmT39/P1iKQFNTk812fHyMxsZGXF9fIzo6GtXV1YLEyiGQw8ND/scDAwNviiNqamp499sTGxvLX4y6vKWlhbeztrYGrwns6elBQ0MDH1v2ont7e/mYtIdegDzlDNnb2tqwuLjIvbu6ugqvCdzf30dJSYmDbW9vD93d3TCZTA52EhcaGuq2HQqY5eVlHjCRkZF4D0FRfHJygpCQEBc7BcnGxgYCAhyboUCpqKh4tb3k5GRERUXxQPOKQLPZjLi4OPcN2Imzpp+VlRXMzs6+2l5MTAxPT0IQ1MUkwtlLxNHRke28rq4OVVVVkMvlPBW9x9PTE4QgyINBQUE4PT211SllUBReXV2hq6uL28bGxuALBAlMSEjgQUL09fVhfX2de6CsrAy+RvBUl5OTw/MWJVuCxpo/EJxmKisreS70N4I9mJ2djfz8fC6yubnZ4drDwwOfZSjlsOWby7M0exQVFXk0JEStZij7a7VaaDQahIWF2aY8WgiQiPb2drfP0YKhtbWVv2BiYiLEILiLrdA8mpmZifn5eZuNlll5eXl8dnBXUlJSkJubi4ODA4jFo/VgeXk5Li8v4Q9Ee9AK+yTk6z3CXRJ3xvkeSuhCEL1g9Tcee9BfkEAjpIueBOohUVhONdF38R9IFKZtTka7qff397R59BF7gm9hZJ+vKrlKpTKzyjdIDLZXqaEjj2Lah2Pu1EIikLiMjIwROnfYo97c3OxkCbQDHwg5Kj09/bu17rKJzkSqX0Qq4V/4UKPetDfKXrv7RWgpbc/5cAfMyIqeMgn7rBh5iQcH/gHXEHXLrlONWwAAAABJRU5ErkJggg==") {
                coin.updateSymbolImage(coin.marketName)
                coinRepository.save(coin)
            }
        }
    }
}
