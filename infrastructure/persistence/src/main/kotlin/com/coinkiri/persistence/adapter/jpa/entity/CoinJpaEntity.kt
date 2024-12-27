package com.coinkiri.persistence.adapter.jpa.entity

import com.coinkiri.domain.coin.Coin
import jakarta.persistence.*
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

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    val symbol: String,

    @Column(nullable = false)
    val createdAt: LocalDateTime,

    ) {
    companion object {
        fun fromList(coinList: List<Coin>): List<CoinJpaEntity> {
            return coinList.map { from(it) }
        }

        fun from(coin: Coin): CoinJpaEntity {
            return CoinJpaEntity(
                marketName = coin.marketName,
                koreanName = coin.koreanName,
                englishName = coin.englishName,
                symbol = coin.symbol,
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
