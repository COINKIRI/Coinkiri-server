package com.coinkiri.persistence.adapter.jpa.repository

import com.coinkiri.persistence.adapter.jpa.entity.MemberJpaEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MemberJpaRepository : JpaRepository<MemberJpaEntity, Long>
