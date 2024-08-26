package com.coinkiri.persistence.adapter.jpa

import com.coinkiri.application.port.out.jpa.CoinRepository
import com.coinkiri.persistence.adapter.jpa.repository.CoinJpaRepository
import org.springframework.stereotype.Repository

@Repository
class CoinJpaAdapter(
    private val coinJpaRepository: CoinJpaRepository
) : CoinRepository {

}