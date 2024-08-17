package com.coinkiri.application.service.auth

import com.coinkiri.application.port.`in`.usecase.SocialLogin
import com.coinkiri.application.service.auth.strategy.KakaoLoginService
import com.coinkiri.domain.member.SocialType
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component

@Component
class SocialLoginProvider(
    private val kakaoLoginService: KakaoLoginService,
    // TODO private val naverAuthService: NaverAuthService
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
