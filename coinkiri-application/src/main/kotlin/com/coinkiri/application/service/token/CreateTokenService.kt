package com.coinkiri.application.service.token

import com.coinkiri.application.port.`in`.usecase.CreateToken
import com.coinkiri.application.port.out.dto.TokenDto
import com.coinkiri.application.port.out.oauth2.JwtHandler
import org.springframework.stereotype.Service

@Service
class CreateTokenService(
    private val jwtHandler: JwtHandler
) : CreateToken {

    override fun invoke(command: CreateToken.Command): TokenDto {
        return jwtHandler.createToken(command.memberId)
    }
}
