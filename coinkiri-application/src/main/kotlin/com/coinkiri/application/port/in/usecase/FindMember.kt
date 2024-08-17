package com.coinkiri.application.port.`in`.usecase

import com.coinkiri.domain.member.Member

interface FindMember {

    fun findMemberById(id: Long): Member
}
