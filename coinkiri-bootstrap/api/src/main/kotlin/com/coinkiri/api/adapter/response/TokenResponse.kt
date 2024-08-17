package com.coinkiri.api.adapter.response

sealed class TokenResponse {

    data class Success(
        val accessToken: String,
        val refreshToken: String
    ) : TokenResponse()

    data class Failure(
        val message: String
    ) : TokenResponse()
}
