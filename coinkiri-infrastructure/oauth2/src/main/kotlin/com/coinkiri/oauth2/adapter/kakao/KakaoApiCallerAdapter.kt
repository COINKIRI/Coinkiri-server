package com.coinkiri.oauth2.adapter.kakao

import com.coinkiri.application.port.out.oauth2.OAuthApiCaller
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class KakaoApiCallerAdapter(
    private val webClient: WebClient
) : OAuthApiCaller {

    override fun getProfile(accessToken: String) {
        TODO("Not yet implemented")
    }
}
