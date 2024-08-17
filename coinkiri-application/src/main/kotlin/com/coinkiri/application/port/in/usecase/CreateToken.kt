package com.coinkiri.application.port.`in`.usecase

import com.coinkiri.application.port.out.dto.TokenDto

interface CreateToken {

    fun invoke(command: Command): TokenDto

    data class Command(
        val memberId: Long?
    )
}