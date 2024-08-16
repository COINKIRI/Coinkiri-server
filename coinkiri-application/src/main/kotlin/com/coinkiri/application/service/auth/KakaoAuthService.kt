package com.coinkiri.application.service.auth

import com.coinkiri.application.port.`in`.usecase.AuthUseCase
import com.coinkiri.application.port.out.oauth2.OAuthApiCaller
import com.coinkiri.application.service.member.MemberService
import org.springframework.stereotype.Service

@Service
class KakaoAuthService(
    private val oAuthApiCaller: OAuthApiCaller,
    private val memberService: MemberService
) : AuthUseCase {

    override fun signUp() {
        TODO("Not yet implemented")
    }
}
