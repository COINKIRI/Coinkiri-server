package com.coinkiri.api.adapter.request

import com.fasterxml.jackson.annotation.JsonCreator

data class SocialLoginRequest @JsonCreator constructor(
    val platform: String
)
