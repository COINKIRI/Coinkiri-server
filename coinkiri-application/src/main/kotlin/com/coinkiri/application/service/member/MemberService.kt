package com.coinkiri.application.service.member

import com.coinkiri.application.port.`in`.usecase.MemberUseCase
import com.coinkiri.application.port.out.jpa.MemberRepository
import com.coinkiri.domain.member.Member
import com.coinkiri.domain.member.MemberCreate
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val memberRepository: MemberRepository
) : MemberUseCase {

    override fun create(memberCreate: MemberCreate): Member {
        val member = Member.from(memberCreate)
        return memberRepository.save(member)
    }
}
