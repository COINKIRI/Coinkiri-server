package com.coinkiri.api.adapter.response

import com.coinkiri.domain.member.Member

data class MemberResponse(
    val id: Long,
    val nickname: String,
) {
    companion object {
        fun of(member: Member): MemberResponse {
            return MemberResponse(
                id = member.id!!,
                nickname = member.nickname
            )
        }
    }
}
