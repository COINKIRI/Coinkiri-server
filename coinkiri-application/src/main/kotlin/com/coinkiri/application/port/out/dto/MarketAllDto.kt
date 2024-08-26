package com.coinkiri.application.port.out.dto

data class MarketEvent(
    val warning: Boolean,
    val caution: Caution
)

data class Caution(
    val PRICE_FLUCTUATIONS: Boolean,
    val TRADING_VOLUME_SOARING: Boolean,
    val DEPOSIT_AMOUNT_SOARING: Boolean,
    val GLOBAL_PRICE_DIFFERENCES: Boolean,
    val CONCENTRATION_OF_SMALL_ACCOUNTS: Boolean
)

data class CoinInfo(
    val market: String,
    val korean_name: String,
    val english_name: String,
    val market_warning: String,
    val market_event: MarketEvent
)
