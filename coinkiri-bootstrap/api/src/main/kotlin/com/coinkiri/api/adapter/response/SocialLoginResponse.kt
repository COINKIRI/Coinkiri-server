package com.coinkiri.api.adapter.response


sealed class SocialLoginResponse {

    data class Success(
        val accessToken: String,
        val refreshToken: String,
    ) : SocialLoginResponse()
}
