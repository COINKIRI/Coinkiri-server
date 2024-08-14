package com.coinkiri.persistence.member.adapter.jpa.repository

import com.coinkiri.persistence.member.adapter.jpa.entity.MemberJpaEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MemberJpaRepository : JpaRepository<MemberJpaEntity, Long>