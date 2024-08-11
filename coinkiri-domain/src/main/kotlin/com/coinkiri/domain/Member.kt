package com.coinkiri.domain

data class Member(
    val id: Long,
    val socialId: String,
    val socialType: String,
    val nickname: String
)