package com.coinkiri.api.adapter.request

import com.coinkiri.application.port.`in`.command.SignUpCommand

data class SignUpRequest(
    val token: String,
    val socialType: String,
    val nickname: String
) {
    fun to() = SignUpCommand(
        token = token,
        socialType = socialType,
        nickname = nickname
    )
}
