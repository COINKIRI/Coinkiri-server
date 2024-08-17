package com.coinkiri.oauth2.adapter.kakao

import com.coinkiri.application.port.out.dto.SocialProfileDto
import com.coinkiri.application.port.out.oauth2.KakaoApiCaller
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class KakaoApiCallerAdapter(
    private val webClient: WebClient
) : KakaoApiCaller {

    override fun getProfile(accessToken: String): SocialProfileDto {
        return webClient.get()
            .uri("https://kapi.kakao.com/v2/user/me")
            .headers { it.setBearerAuth(accessToken) }
            .retrieve()
            .bodyToMono(SocialProfileDto::class.java)
            .block()!!
    }
}
