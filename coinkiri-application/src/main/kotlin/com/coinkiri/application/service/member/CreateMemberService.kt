package com.coinkiri.application.service.member

import com.coinkiri.application.port.`in`.usecase.CreateMember
import com.coinkiri.application.port.out.jpa.MemberRepository
import com.coinkiri.domain.member.Member
import com.coinkiri.domain.member.MemberCreate
import org.springframework.stereotype.Service

@Service
class CreateMemberService(
    private val memberRepository: MemberRepository
) : CreateMember {

    override fun invoke(command: CreateMember.Command): Member {
        return memberRepository.save(
            Member.from(
                MemberCreate(
                    socialId = command.socialId,
                    socialType = command.socialType,
                    nickname = command.nickname
                )
            )
        )
    }
}
