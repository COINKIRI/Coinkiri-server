package com.coinkiri.application.service.member

import com.coinkiri.application.port.`in`.usecase.CheckRegistered
import com.coinkiri.application.port.out.jpa.MemberRepository
import com.coinkiri.domain.member.Member
import org.springframework.stereotype.Service

@Service
class CheckRegisteredService(
    private val memberRepository: MemberRepository
) : CheckRegistered {

    override fun invoke(command: CheckRegistered.Command): Member? {
        return memberRepository.findBySocialIdAndSocialType(command.socialId, command.socialType.toString())
    }
}
