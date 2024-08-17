package com.coinkiri.application.port.`in`.usecase

interface CreateToken {

    fun invoke(command: Command)

    data class Command(
        val memberId: Long
    )
}