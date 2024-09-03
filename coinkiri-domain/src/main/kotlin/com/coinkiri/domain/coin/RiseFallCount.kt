package com.coinkiri.domain.coin

data class RiseFallCount(
    val riseCount: Int,
    val fallCount: Int
) {
    companion object {
        fun count(rateList: List<Double>): RiseFallCount {
            var riseCount = 0
            var fallCount = 0
            rateList.forEach {
                if (it >= 0) {
                    riseCount++
                } else {
                    fallCount++
                }
            }
            return RiseFallCount(riseCount, fallCount)
        }
    }
}
