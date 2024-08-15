package com.coinkiri.api.adapter.response

import com.coinkiri.domain.member.Member

data class MemberResponse(
    val id: Long,
    val socialId: String,
    val socialType: String,
    val nickname: String
) {
    companion object {
        fun from(member: Member) =
            MemberResponse(
                id = member.id!!,
                socialId = member.socialId,
                socialType = member.socialType.name,
                nickname = member.nickname
            )
    }
}
