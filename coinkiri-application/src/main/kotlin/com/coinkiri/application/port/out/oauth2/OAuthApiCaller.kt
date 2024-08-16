package com.coinkiri.application.port.out.oauth2

import com.coinkiri.application.service.auth.dto.KakaoProfileResponse

interface OAuthApiCaller {

    fun getProfile(accessToken: String): KakaoProfileResponse
}
