package com.coinkiri.persistence.adapter.jpa.entity

import com.coinkiri.domain.coin.Coin
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "coins")
data class CoinJpaEntity(

    @Id
    val marketName: String,

    @Column(nullable = false)
    val koreanName: String,

    @Column(nullable = false)
    val englishName: String,

    val symbol: ByteArray = byteArrayOf(),

    @Column(nullable = false)
    val createdAt: LocalDateTime,

    ) {
    companion object {
        fun fromList(coinList: List<Coin>): List<CoinJpaEntity> {
            return coinList.map { from(it) }
        }

        private fun from(coin: Coin): CoinJpaEntity {
            return CoinJpaEntity(
                marketName = coin.marketName,
                koreanName = coin.koreanName,
                englishName = coin.englishName,
                createdAt = coin.createdAt,
            )
        }
    }

    fun toDomain(): Coin {
        return Coin(
            marketName = marketName,
            koreanName = koreanName,
            englishName = englishName,
            symbol = symbol,
            createdAt = createdAt
        )
    }
}
