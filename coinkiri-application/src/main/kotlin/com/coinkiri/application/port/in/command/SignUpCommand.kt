package com.coinkiri.application.port.`in`.command

import com.coinkiri.domain.member.MemberCreate
import com.coinkiri.domain.member.SocialType

data class SignUpCommand(
    val token: String,
    val socialType: SocialType,
    val nickname: String
) {
    fun to(socialId: String) = MemberCreate(
        socialId = socialId,
        socialType = socialType,
        nickname = nickname
    )
}
