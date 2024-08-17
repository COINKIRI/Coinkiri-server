package com.coinkiri.application.service.token

import com.coinkiri.application.port.`in`.usecase.FindMember
import com.coinkiri.application.port.`in`.usecase.ReissueToken
import com.coinkiri.application.port.out.dto.TokenDto
import com.coinkiri.application.port.out.oauth2.JwtHandler
import com.coinkiri.application.port.out.redis.RedisHandler
import org.springframework.stereotype.Service

@Service
class ReissueTokenService(
    private val jwtHandler: JwtHandler,
    private val findMember: FindMember,
    private val redisHandler: RedisHandler
) : ReissueToken {

    override fun invoke(command: ReissueToken.Command): TokenDto {
        val memberId = jwtHandler.getMemberIdByToken(command.accessToken)
        val member = findMember.findMemberById(memberId)
        if (!jwtHandler.validateToken(command.refreshToken)) {
            throw IllegalArgumentException(
                "주어진 리프레시 토큰 ${command.refreshToken} 이 유효하지 않습니다."
            )
        }
        val refreshToken = redisHandler.get("refresh_token:$memberId")
            ?: throw IllegalArgumentException(
                "이미 만료된 리프레시 토큰 ${command.refreshToken} 입니다."
            )
        
    }
}
