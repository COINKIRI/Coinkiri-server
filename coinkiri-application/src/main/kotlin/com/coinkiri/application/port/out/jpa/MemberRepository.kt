package com.coinkiri.application.port.out.jpa

import com.coinkiri.domain.member.Member
import com.coinkiri.domain.member.SocialType

interface MemberRepository {

    fun save(member: Member): Member

    fun findById(id: Long): Member

    fun findBySocialIdAndSocialType(socialId: String, socialType: SocialType): Member?

    fun delete(member: Member)
}
