package com.coinkiri.api.adapter.request

data class TokenRequest(
    val accessToken: String,
    val refreshToken: String
)
