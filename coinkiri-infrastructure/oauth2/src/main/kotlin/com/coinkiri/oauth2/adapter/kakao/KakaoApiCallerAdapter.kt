package com.coinkiri.oauth2.adapter.kakao

import com.coinkiri.application.port.out.oauth2.KakaoApiCaller
import org.springframework.stereotype.Component

@Component
class KakaoApiCallerAdapter : KakaoApiCaller {

    override fun getProfile() {
        TODO("Not yet implemented")
    }
}