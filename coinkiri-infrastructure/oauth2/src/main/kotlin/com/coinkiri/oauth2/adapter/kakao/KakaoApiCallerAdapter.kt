package com.coinkiri.oauth2.adapter.kakao

import com.coinkiri.application.port.out.oauth2.KakaoApiCaller
import com.coinkiri.application.service.auth.dto.KakaoProfileResponse
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class KakaoApiCallerAdapter(
    private val webClient: WebClient
) : KakaoApiCaller {

    override fun getProfile(accessToken: String): KakaoProfileResponse {
        return webClient.get()
            .uri("https://kapi.kakao.com/v2/user/me")
            .headers { it.setBearerAuth(accessToken) }
            .retrieve()
            .bodyToMono(KakaoProfileResponse::class.java)
            .block()!!
    }
}
