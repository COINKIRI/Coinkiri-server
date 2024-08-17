package com.coinkiri.application.service.auth

import com.coinkiri.application.port.`in`.usecase.SocialLogin
import com.coinkiri.domain.member.SocialType
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component

@Component
class AuthServiceProvider(
    private val kakaoLoginService: KakaoLoginService
) {
    companion object {
        val authServiceMap = mutableMapOf<SocialType, SocialLogin>()
    }

    @PostConstruct
    fun initAuthServiceMap() {
        authServiceMap[SocialType.KAKAO] = kakaoLoginService
        // TODO authServiceMap[SocialType.NAVER] = naverAuthService
    }

    fun getAuthService(socialType: SocialType): SocialLogin {
        return authServiceMap[socialType]!!
    }
}
