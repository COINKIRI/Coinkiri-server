package com.coinkiri.domain

data class Member(
    val id: Long,
    val socialId: String,
    val socialType: SocialType,
    val nickname: String
) {
}