package com.coinkiri.application.port.`in`.usecase

import com.coinkiri.domain.member.SocialType

fun interface SocialLogin {

    fun invoke(command: Command): Result

    data class Command(
        val token: String,
        val socialType: SocialType,
        val nickname: String
    )

    sealed class Result {
        data class Success(
            val accessToken: String,
            val refreshToken: String
        ) : Result()

        // TODO data class Failure() : Result()
    }
}
