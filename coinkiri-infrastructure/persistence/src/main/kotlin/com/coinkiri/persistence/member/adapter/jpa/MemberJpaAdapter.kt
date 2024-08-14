package com.coinkiri.persistence.member.adapter.jpa

import com.coinkiri.application.member.port.out.jpa.MemberRepository
import com.coinkiri.domain.member.Member
import com.coinkiri.persistence.member.adapter.jpa.entity.MemberJpaEntity
import com.coinkiri.persistence.member.adapter.jpa.repository.MemberJpaRepository

class MemberJpaAdapter (
    private val memberJpaRepository: MemberJpaRepository
) : MemberRepository {

    override fun save(member: Member): Member {
        return memberJpaRepository.save(MemberJpaEntity.from(member)).toDomain()
    }
}