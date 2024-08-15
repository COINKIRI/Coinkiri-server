package com.coinkiri.domain.member

import java.time.LocalDateTime

data class Member(
    val id: Long? = null,
    val socialId: String,
    val socialType: SocialType,
    val nickname: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    companion object {
        fun from(memberCreate: MemberCreate): Member =
            Member(
                socialId = memberCreate.socialId,
                socialType = memberCreate.socialType,
                nickname = memberCreate.nickname,
                createdAt = LocalDateTime.now(),
                updatedAt = LocalDateTime.now()
            )
    }
}
