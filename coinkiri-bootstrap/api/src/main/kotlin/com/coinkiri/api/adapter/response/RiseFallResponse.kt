package com.coinkiri.api.adapter.response

import com.coinkiri.domain.coin.RiseFallCount

data class RiseFallResponse(
    val riseCount: Int,
    val fallCount: Int
) {
    companion object {
        fun of(riseFallCount: RiseFallCount): RiseFallResponse {
            return RiseFallResponse(
                riseCount = riseFallCount.riseCount,
                fallCount = riseFallCount.fallCount
            )
        }
    }
}
