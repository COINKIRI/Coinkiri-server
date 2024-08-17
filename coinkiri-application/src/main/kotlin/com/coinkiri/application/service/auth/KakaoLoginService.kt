package com.coinkiri.application.service.auth

import com.coinkiri.application.port.`in`.usecase.CreateMember
import com.coinkiri.application.port.`in`.usecase.SocialLogin
import com.coinkiri.application.port.out.oauth2.KakaoApiCaller
import org.springframework.stereotype.Service

@Service
class KakaoLoginService(
    private val kakaoApiCaller: KakaoApiCaller,
    private val createMember: CreateMember
) : SocialLogin {

    override fun invoke(command: SocialLogin.Command): SocialLogin.Result {
        val kakaoProfile = kakaoApiCaller.getProfile(command.token)
        
        return SocialLogin.Result.Success(
            accessToken = "accessToken",
            refreshToken = "refreshToken"
        )
    }
}
