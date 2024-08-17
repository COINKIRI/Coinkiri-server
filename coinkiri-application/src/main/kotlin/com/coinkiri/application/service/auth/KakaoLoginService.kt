package com.coinkiri.application.service.auth

import com.coinkiri.application.port.`in`.command.SignUpCommand
import com.coinkiri.application.port.`in`.usecase.CreateMember
import com.coinkiri.application.port.`in`.usecase.SocialLogin
import com.coinkiri.application.port.out.oauth2.KakaoApiCaller
import com.coinkiri.domain.member.Member
import org.springframework.stereotype.Service

@Service
class KakaoLoginService(
    private val kakaoApiCaller: KakaoApiCaller,
    private val createMember: CreateMember
) : SocialLogin {

    override fun socialLogin(signUpCommand: SignUpCommand): Member {
        val kakaoProfile = kakaoApiCaller.getProfile(signUpCommand.token)
        return createMember.create(signUpCommand.to(kakaoProfile.socialId))
    }
}
