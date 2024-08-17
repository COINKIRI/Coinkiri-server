package com.coinkiri.application.service.token

import com.coinkiri.application.port.`in`.usecase.ReissueToken
import com.coinkiri.application.port.out.dto.TokenDto
import com.coinkiri.application.port.out.oauth2.JwtHandler

class ReissueTokenService(
    private val jwtHandler: JwtHandler,
) : ReissueToken {
    override fun invoke(command: ReissueToken.Command): TokenDto {
        TODO("Not yet implemented")
    }
}
