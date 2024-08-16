package com.coinkiri.application

import com.coinkiri.application.port.`in`.usecase.AuthUseCase
import com.coinkiri.application.port.out.oauth2.OAuthApiCaller
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
