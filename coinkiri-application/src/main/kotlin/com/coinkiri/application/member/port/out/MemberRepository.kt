package com.coinkiri.application.member.port.out

import com.coinkiri.domain.member.Member

interface MemberRepository {

    fun save(member: Member) : Member
}