package com.coinkiri.oauth2.adapter.jwt

import com.coinkiri.application.port.out.dto.TokenDto
import com.coinkiri.application.port.out.oauth2.JwtHandler
import com.coinkiri.application.port.out.oauth2.JwtKey
import com.coinkiri.application.port.out.redis.RedisHandler
import com.coinkiri.application.port.out.redis.RedisKey
import com.coinkiri.common.log.Slf4JKotlinLogging.log
import io.jsonwebtoken.*
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.io.DecodingException
import io.jsonwebtoken.security.Keys
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.security.Key
import java.util.*

@Component
class JwtHandlerAdapter(
    private val redisHandler: RedisHandler
) : JwtHandler {
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
            .claim(JwtKey.MEMBER_ID, memberId)
            .setExpiration(accessTokenExpiresIn)
            .signWith(secretKey, SignatureAlgorithm.HS512)
            .compact()

        val refreshToken: String = Jwts.builder()
            .setExpiration(refreshTokenExpiresIn)
            .signWith(secretKey, SignatureAlgorithm.HS512)
            .compact()

        redisHandler.set(RedisKey.REFRESH_TOKEN + memberId, refreshToken, REFRESH_TOKEN_EXPIRE_TIME)

        return TokenDto(accessToken, refreshToken)
    }

    override fun validateToken(token: String?): Boolean {
        try {
            Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
            return true
        } catch (e: SecurityException) {
            log.warn(e) { "Invalid JWT Token" }
        } catch (e: MalformedJwtException) {
            log.warn(e) { "Invalid JWT Token" }
        } catch (e: DecodingException) {
            log.warn(e) { "Invalid JWT Token" }
        } catch (e: ExpiredJwtException) {
            log.warn(e) { "Expired JWT Token" }
        } catch (e: UnsupportedJwtException) {
            log.warn(e) { "Unsupported JWT Token" }
        } catch (e: IllegalArgumentException) {
            log.warn(e) { "JWT claims string is empty." }
        } catch (e: Exception) {
            log.error(e) { "Unhandled JWT exception" }
        }
        return false
    }

    override fun expireRefreshToken(memberId: Long) {
        redisHandler.delete(RedisKey.REFRESH_TOKEN + memberId)
    }

    override fun getMemberIdByToken(accessToken: String): Long {
        val memberId = parseClaims(accessToken)[JwtKey.MEMBER_ID] as Int?
        return memberId?.toLong() ?: throw IllegalArgumentException(
            "주어진 액세스 토큰 $accessToken 으로 멤버 정보를 찾을 수 없습니다."
        )
    }

    private fun parseClaims(accessToken: String): Claims {
        return try {
            Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(accessToken).body
        } catch (e: ExpiredJwtException) {
            e.claims
        }
    }


}
