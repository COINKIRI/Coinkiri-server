package com.coinkiri.application.port.out.oauth2

import com.coinkiri.application.port.out.dto.SocialProfileDto

interface KakaoApiCaller {

    fun getProfile(accessToken: String): SocialProfileDto
}
