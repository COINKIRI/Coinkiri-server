package com.coinkiri.oauth2.adapter.jwt

import com.coinkiri.application.port.out.oauth2.JwtHandler
import com.coinkiri.application.port.out.oauth2.LoginCheckHandler
import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Component

@Component
class LoginCheckHandlerAdapter(
    private val jwtHandler: JwtHandler
) : LoginCheckHandler {

    override fun getMemberId(request: HttpServletRequest): Long {
        val bearerToken: String? = request.getHeader("Authorization")
        if (!bearerToken.isNullOrBlank() && bearerToken.startsWith("Bearer ")) {
            val accessToken = bearerToken.substring("Bearer ".length)
            if (jwtHandler.validateToken(accessToken)) {
                return jwtHandler.getMemberIdByToken(accessToken)
            }
        }
        throw IllegalArgumentException("잘못된 JWT $bearerToken 입니다.")
    }
}
