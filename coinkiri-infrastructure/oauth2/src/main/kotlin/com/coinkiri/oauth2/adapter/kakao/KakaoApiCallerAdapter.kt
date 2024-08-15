package com.coinkiri.oauth2.adapter.kakao

import com.coinkiri.application.port.out.oauth2.OAuthApiCaller
import org.springframework.stereotype.Component

@Component
class KakaoApiCallerAdapter : OAuthApiCaller {

    override fun getProfile() {
        TODO("Not yet implemented")
    }
}
