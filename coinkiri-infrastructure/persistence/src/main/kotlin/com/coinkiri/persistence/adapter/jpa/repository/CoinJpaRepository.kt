package com.coinkiri.persistence.adapter.jpa.repository

import com.coinkiri.persistence.adapter.jpa.entity.CoinJpaEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CoinJpaRepository : JpaRepository<CoinJpaEntity, Long> {
    
}
