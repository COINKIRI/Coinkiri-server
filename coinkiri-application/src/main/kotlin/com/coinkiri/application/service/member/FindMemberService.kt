package com.coinkiri.application.service.member

import com.coinkiri.application.port.`in`.usecase.FindMember
import com.coinkiri.application.port.out.jpa.MemberRepository
import com.coinkiri.domain.member.Member
import org.springframework.stereotype.Service

@Service
class FindMemberService(
    private val memberRepository: MemberRepository
) : FindMember {

    override fun findMemberById(id: Long): Member {
        return memberRepository.findById(id)
    }
}
