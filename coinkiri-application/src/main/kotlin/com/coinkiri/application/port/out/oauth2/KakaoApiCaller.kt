package com.coinkiri.application.port.out.oauth2

import com.coinkiri.application.port.out.command.CacheProfileCommand

interface KakaoApiCaller {

    fun getProfile(accessToken: String): CacheProfileCommand
}
