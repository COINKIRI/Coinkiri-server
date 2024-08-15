package com.coinkiri.domain.member

data class MemberCreate(
    val socialId: String,
    val socialType: SocialType,
    val nickname: String
) {
}
