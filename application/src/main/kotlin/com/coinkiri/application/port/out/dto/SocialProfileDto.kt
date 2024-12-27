package com.coinkiri.application.port.out.dto

import com.fasterxml.jackson.annotation.JsonCreator

data class SocialProfileDto @JsonCreator constructor(
    val id: String
)
