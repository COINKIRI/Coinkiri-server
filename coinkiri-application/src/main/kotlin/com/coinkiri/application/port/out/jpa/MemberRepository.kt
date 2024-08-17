package com.coinkiri.application.port.out.jpa

import com.coinkiri.domain.member.Member

interface MemberRepository {

    fun save(member: Member): Member

    fun findById(id: Long): Member

    fun findBySocialIdAndSocialType(socialId: String, socialType: String): Member?
}
