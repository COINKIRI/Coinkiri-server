package com.coinkiri.application.service.auth

import com.coinkiri.application.port.`in`.usecase.FindMember
import com.coinkiri.application.port.`in`.usecase.SocialLogout
import com.coinkiri.application.port.out.oauth2.JwtHandler
import org.springframework.stereotype.Service

@Service
class SocialLogoutService(
    private val findMember: FindMember,
    private val jwtHandler: JwtHandler
) : SocialLogout {

    override fun invoke(command: SocialLogout.Command): SocialLogout.Result {
        val member = findMember.findMemberById(command.memberId)
        jwtHandler.expireRefreshToken(member.id!!)
        return SocialLogout.Result.Success(
            message = "로그아웃 되었습니다 : ${member.id}, ${member.nickname}"
        )
    }
}
