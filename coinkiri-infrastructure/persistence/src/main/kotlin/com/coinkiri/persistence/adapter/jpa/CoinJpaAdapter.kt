package com.coinkiri.persistence.adapter.jpa

import com.coinkiri.application.port.out.jpa.CoinRepository
import com.coinkiri.domain.coin.Coin
import com.coinkiri.persistence.adapter.jpa.entity.CoinJpaEntity
import com.coinkiri.persistence.adapter.jpa.repository.CoinJpaRepository
import org.springframework.stereotype.Repository

@Repository
class CoinJpaAdapter(
    private val coinJpaRepository: CoinJpaRepository
) : CoinRepository {

    override fun saveAll(coinList: List<Coin>): List<Coin> {
        return coinJpaRepository.saveAll(CoinJpaEntity.fromList(coinList)).map { it.toDomain() }
    }

    override fun findAll(): List<Coin> {
        return coinJpaRepository.findAllByOrderByCreatedAtAsc().map { it.toDomain() }
    }

    override fun save(coin: Coin) {
        coinJpaRepository.save(CoinJpaEntity.from(coin))
    }
}
