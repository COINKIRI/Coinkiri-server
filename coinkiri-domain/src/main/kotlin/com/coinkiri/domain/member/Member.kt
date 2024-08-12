package com.coinkiri.domain.member

class Member(
    val id: Long? = null,
    val socialId: String,
    val socialType: SocialType,
    val nickname: String
) {
    companion object {
        fun from(memberCreate: MemberCreate): Member =
            Member(
                socialId = memberCreate.socialId,
                socialType = memberCreate.socialType,
                nickname = memberCreate.nickname
            )
    }
}