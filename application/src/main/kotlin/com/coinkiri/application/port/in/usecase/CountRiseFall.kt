package com.coinkiri.application.port.`in`.usecase

import com.coinkiri.domain.coin.RiseFallCount

interface CountRiseFall {

    fun countRiseAndFall(): RiseFallCount
}
