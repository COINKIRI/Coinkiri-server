package com.coinkiri.api.adapter.request

data class SocialLoginRequest(
    val token: String,
    val socialType: String,
    val nickname: String
)
