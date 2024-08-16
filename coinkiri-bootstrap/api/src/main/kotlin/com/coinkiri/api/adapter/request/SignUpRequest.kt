package com.coinkiri.api.adapter.request

import com.coinkiri.application.port.`in`.command.SignUpCommand
import com.coinkiri.domain.member.SocialType

data class SignUpRequest(
    val token: String,
    val socialType: String,
    val nickname: String
) {
    fun to() = SignUpCommand(
        token = token,
        socialType = SocialType.valueOf(socialType),
        nickname = nickname
    )
}
