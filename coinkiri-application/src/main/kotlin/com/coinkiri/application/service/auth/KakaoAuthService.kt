package com.coinkiri.application.service.auth

import com.coinkiri.application.port.`in`.usecase.AuthUseCase
import com.coinkiri.application.port.out.oauth2.KakaoApiCaller
import com.coinkiri.application.service.member.MemberService
import org.springframework.stereotype.Service

@Service
class KakaoAuthService(
    private val kakaoApiCaller: KakaoApiCaller,
    private val memberService: MemberService
) : AuthUseCase {

    override fun signUp(accessToken: String) {
        val kakaoProfile = kakaoApiCaller.getProfile(accessToken)
        // TODO member save
    }
}
