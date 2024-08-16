package com.coinkiri.application.service.auth

import com.coinkiri.application.port.`in`.command.SignUpCommand
import com.coinkiri.application.port.`in`.usecase.AuthUseCase
import com.coinkiri.application.port.`in`.usecase.MemberUseCase
import com.coinkiri.application.port.out.oauth2.KakaoApiCaller
import com.coinkiri.domain.member.Member
import org.springframework.stereotype.Service

@Service
class KakaoAuthService(
    private val kakaoApiCaller: KakaoApiCaller,
    private val memberUseCase: MemberUseCase
) : AuthUseCase {

    override fun signUp(signUpCommand: SignUpCommand): Member {
        val kakaoProfile = kakaoApiCaller.getProfile(signUpCommand.token)
        val member = memberUseCase.create(signUpCommand.to(kakaoProfile.socialId))
        return member
    }
}
