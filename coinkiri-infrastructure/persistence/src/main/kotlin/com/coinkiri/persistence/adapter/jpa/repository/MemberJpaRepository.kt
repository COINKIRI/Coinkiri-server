package com.coinkiri.persistence.adapter.jpa.repository

import com.coinkiri.domain.member.SocialType
import com.coinkiri.persistence.adapter.jpa.entity.MemberJpaEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MemberJpaRepository : JpaRepository<MemberJpaEntity, Long> {

    fun findBySocialIdAndSocialType(socialId: String, socialType: SocialType): MemberJpaEntity?
}
