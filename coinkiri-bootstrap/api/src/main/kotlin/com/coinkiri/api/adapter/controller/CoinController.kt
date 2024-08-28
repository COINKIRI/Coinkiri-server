package com.coinkiri.api.adapter.controller

import com.coinkiri.application.port.`in`.usecase.FindAllCoin
import com.coinkiri.application.port.`in`.usecase.GetCoinDetail
import com.coinkiri.common.response.ApiResponse
import com.coinkiri.domain.coin.Coin
import com.coinkiri.domain.coin.CoinDetail
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Coin")
@RestController
@RequestMapping("api/v1/coin")
class CoinController(
    private val findAllCoin: FindAllCoin,
    private val getCoinDetail: GetCoinDetail
) {

    @Operation(summary = "코인 리스트 조회")
    @GetMapping("/all")
    fun findAllCoin(): ResponseEntity<ApiResponse<List<Coin>>> {

        val coinList = findAllCoin.findAllCoin()

        return ResponseEntity.ok(ApiResponse.success(coinList))
    }

    @Operation(summary = "코인 상세 조회")
    @GetMapping("/detail")
    fun getCoinDetail(
        market: String
    ): ResponseEntity<ApiResponse<CoinDetail>> {

        val coinDetail = getCoinDetail.getCoinDetail(market)

        return ResponseEntity.ok(ApiResponse.success(coinDetail))
    }
}
