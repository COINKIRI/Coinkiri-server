package com.coinkiri.application.port.out.oauth2

import com.coinkiri.application.service.auth.dto.KakaoProfileResponse

interface KakaoApiCaller {

    fun getProfile(accessToken: String): KakaoProfileResponse
}
