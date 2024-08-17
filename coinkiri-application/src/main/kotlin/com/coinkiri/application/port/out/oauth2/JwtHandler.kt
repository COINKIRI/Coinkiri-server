package com.coinkiri.application.port.out.oauth2

import com.coinkiri.application.port.out.dto.TokenDto

interface JwtHandler {

    fun createToken(memberId: Long?): TokenDto

    fun getMemberIdByToken(accessToken: String): Long

    fun validateToken(token: String?): Boolean
}
