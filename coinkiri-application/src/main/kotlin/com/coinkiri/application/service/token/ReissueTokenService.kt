package com.coinkiri.application.service.token

import com.coinkiri.application.port.`in`.usecase.FindMember
import com.coinkiri.application.port.`in`.usecase.ReissueToken
import com.coinkiri.application.port.out.oauth2.JwtHandler
import com.coinkiri.application.port.out.redis.RedisHandler
import org.springframework.stereotype.Service

@Service
class ReissueTokenService(
    private val jwtHandler: JwtHandler,
    private val findMember: FindMember,
    private val redisHandler: RedisHandler
) : ReissueToken {

    override fun invoke(command: ReissueToken.Command): ReissueToken.Result {
        val memberId = jwtHandler.getMemberIdByToken(command.accessToken)
        val member = findMember.findMemberById(memberId)
        if (!jwtHandler.validateToken(command.refreshToken)) {
            return ReissueToken.Result.Failure(
                message = "유효하지 않은 리프레시 토큰입니다: ${command.refreshToken}"
            )
        }
        val refreshToken = redisHandler.get("refresh_token:$memberId")
            ?: return ReissueToken.Result.Failure(
                message = "만료된 리프레시 토큰입니다: ${command.refreshToken}"
            )
        if (refreshToken != command.refreshToken) {
            jwtHandler.expireRefreshToken(member.id!!)
            return ReissueToken.Result.Failure(
                message = "리프레시 토큰의 정보가 일치하지 않습니다: ${command.refreshToken}"
            )
        }
        val newToken = jwtHandler.createToken(memberId)

        return ReissueToken.Result.Success(
            accessToken = newToken.accessToken,
            refreshToken = newToken.refreshToken
        )
    }
}
