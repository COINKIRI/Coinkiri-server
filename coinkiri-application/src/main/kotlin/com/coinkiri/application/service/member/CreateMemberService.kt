package com.coinkiri.application.service.member

import com.coinkiri.application.port.`in`.usecase.CreateMember
import com.coinkiri.application.port.out.jpa.MemberRepository
import com.coinkiri.domain.member.Member
import org.springframework.stereotype.Service

@Service
class CreateMemberService(
    private val memberRepository: MemberRepository
) : CreateMember {

    override fun create(memberCreate: com.coinkiri.domain.member.MemberCreate): Member {
        val member = Member.from(memberCreate)
        return memberRepository.save(member)
    }
}
