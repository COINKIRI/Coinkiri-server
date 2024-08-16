package com.coinkiri.application.service.auth

import com.coinkiri.application.port.`in`.usecase.AuthUseCase
import com.coinkiri.domain.member.SocialType
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component

@Component
class AuthServiceProvider(
    private val kakaoAuthService: KakaoAuthService
) {
    companion object {
        val authServiceMap = mutableMapOf<SocialType, AuthUseCase>()
    }

    @PostConstruct
    fun initAuthServiceMap() {
        authServiceMap[SocialType.KAKAO] = kakaoAuthService
        // TODO authServiceMap[SocialType.NAVER] = naverAuthService
    }

    fun getAuthService(socialType: SocialType): AuthUseCase {
        return authServiceMap[socialType]!!
    }
}