package com.coinkiri.persistence.adapter.jpa

import com.coinkiri.application.port.out.jpa.MemberRepository
import com.coinkiri.domain.member.Member
import com.coinkiri.persistence.adapter.jpa.entity.MemberJpaEntity
import com.coinkiri.persistence.adapter.jpa.repository.MemberJpaRepository
import org.springframework.stereotype.Repository

@Repository
class MemberJpaAdapter(
    private val memberJpaRepository: MemberJpaRepository
) : MemberRepository {

    override fun save(member: Member): Member {
        return memberJpaRepository.save(MemberJpaEntity.from(member)).toDomain()
    }

    override fun findBySocialIdAndSocialType(socialId: String, socialType: String): Member? {
        return memberJpaRepository.findBySocialIdAndSocialType(socialId, socialType)?.toDomain()
    }
}
