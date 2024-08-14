package com.coinkiri.application.member.port.`in`.usecase

import com.coinkiri.domain.member.Member

interface MemberUseCase {
    fun create(member: Member): Member
}