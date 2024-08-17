package com.coinkiri.application.service.member

import com.coinkiri.application.port.`in`.usecase.CreateMember
import com.coinkiri.application.port.out.jpa.MemberRepository
import org.springframework.stereotype.Service

@Service
class CreateMemberService(
    private val memberRepository: MemberRepository
) : CreateMember {

    override fun invoke(command: CreateMember.Command) {}
}
