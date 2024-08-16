package com.coinkiri.application.port.`in`.command

data class SignUpCommand(
    val token: String,
    val socialType: String,
    val nickname: String
)
