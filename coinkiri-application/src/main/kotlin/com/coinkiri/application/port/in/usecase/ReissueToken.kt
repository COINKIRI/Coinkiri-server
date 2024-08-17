package com.coinkiri.application.port.`in`.usecase

import com.coinkiri.application.port.out.dto.TokenDto

fun interface ReissueToken {

    fun invoke(command: Command): TokenDto

    data class Command(
        val accessToken: String,
        val refreshToken: String
    )
}
