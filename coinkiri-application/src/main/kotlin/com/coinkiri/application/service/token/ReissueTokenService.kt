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

    }
}
