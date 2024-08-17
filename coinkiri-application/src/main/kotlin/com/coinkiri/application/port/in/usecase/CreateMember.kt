package com.coinkiri.application.port.`in`.usecase

import com.coinkiri.domain.member.Member
import com.coinkiri.domain.member.MemberCreate

interface CreateMember {

    fun create(memberCreate: MemberCreate): Member
}
