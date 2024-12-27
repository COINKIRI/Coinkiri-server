package com.coinkiri.application.port.`in`.usecase

fun interface SocialLogout {

    fun invoke(command: Command): Result

    data class Command(
        val memberId: Long
    )

    sealed class Result {

        data class Success(
            val message: String
        ) : Result()
    }
}