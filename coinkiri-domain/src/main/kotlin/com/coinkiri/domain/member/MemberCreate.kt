package com.coinkiri.domain.member

class MemberCreate(
    val socialId: String,
    val socialType: SocialType,
    val nickname: String
) {
}
