package com.coinkiri.application.port.`in`.usecase

fun interface ReissueToken {

    fun invoke(command: Command): Result

    data class Command(
        val accessToken: String,
        val refreshToken: String
    )

    sealed class Result {
        
        data class Success(
            val accessToken: String,
            val refreshToken: String
        ) : Result()

        data class Failure(
            val message: String
        ) : Result()
    }
}
