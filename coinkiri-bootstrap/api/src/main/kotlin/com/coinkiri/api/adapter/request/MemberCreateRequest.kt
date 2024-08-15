package com.coinkiri.api.adapter.request

import com.coinkiri.domain.member.MemberCreate
import com.coinkiri.domain.member.SocialType

data class MemberCreateRequest(
    val token: String,
    val socialType: String,
    val nickname: String
) {
    fun to(socialId: String) = MemberCreate(
        socialId = socialId,
        socialType = SocialType.valueOf(socialType),
        nickname = nickname
    )
}
