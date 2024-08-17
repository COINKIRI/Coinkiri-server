package com.coinkiri.application.port.`in`.usecase

import com.coinkiri.domain.member.SocialType

fun interface CreateMember {

    fun invoke(command: Command)

    data class Command(
        val socialId: String,
        val socialType: SocialType,
        val nickname: String
    )
}
