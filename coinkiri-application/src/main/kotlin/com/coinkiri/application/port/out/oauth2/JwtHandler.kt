package com.coinkiri.application.port.out.oauth2

interface JwtHandler {

    fun createToken(memberId: Long)
}
