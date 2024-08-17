package com.coinkiri.oauth2.adapter.jwt

import com.coinkiri.application.port.out.dto.TokenDto
import com.coinkiri.application.port.out.oauth2.JwtHandler
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.security.Key
import java.util.*

@Component
class JwtHandlerAdapter : JwtHandler {
    @Value("\${jwt.secret}")
    private var jwtSecret: String? = null
    private var secretKey: Key? = null

    companion object {
        private const val ACCESS_TOKEN_EXPIRE_TIME = 365 * 24 * 60 * 60 * 1000L;   // 1년
        private const val REFRESH_TOKEN_EXPIRE_TIME = 365 * 24 * 60 * 60 * 1000L;    // 1년
        private const val EXPIRED_TIME = 1L
    }

    @PostConstruct
    fun init() {
        val keyBytes: ByteArray = Decoders.BASE64.decode(jwtSecret)
        this.secretKey = Keys.hmacShaKeyFor(keyBytes)
    }

    override fun createToken(memberId: Long?): TokenDto {
        val now = Date().time
        val accessTokenExpiresIn = Date(now + ACCESS_TOKEN_EXPIRE_TIME)
        val refreshTokenExpiresIn = Date(now + REFRESH_TOKEN_EXPIRE_TIME)

        val accessToken: String = Jwts.builder()
            .claim("MEMBER_ID", memberId)
            .setExpiration(accessTokenExpiresIn)
            .signWith(secretKey, SignatureAlgorithm.HS512)
            .compact()

        val refreshToken: String = Jwts.builder()
            .setExpiration(refreshTokenExpiresIn)
            .signWith(secretKey, SignatureAlgorithm.HS512)
            .compact()

        return TokenDto(accessToken, refreshToken)
    }
}
