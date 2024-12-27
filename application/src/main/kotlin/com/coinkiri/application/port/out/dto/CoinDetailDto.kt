package com.coinkiri.application.port.out.dto

data class CoinDetailDto(
    val market: String,
    val candle_date_time_utc: String,
    val candle_date_time_kst: String,
    val opening_price: Double,
    val high_price: Double,
    val low_price: Double,
    val trade_price: Double,
    val timestamp: Long,
    val candle_acc_trade_price: Double,
    val candle_acc_trade_volume: Double,
    val prev_closing_price: Double,
    val change_price: Double,
    val change_rate: Double
)
