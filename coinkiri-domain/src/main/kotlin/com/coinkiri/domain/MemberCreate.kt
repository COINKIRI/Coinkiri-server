package com.coinkiri.domain

class MemberCreate(
    val socialId: String,
    val socialType: SocialType,
    val nickname: String
) {
}