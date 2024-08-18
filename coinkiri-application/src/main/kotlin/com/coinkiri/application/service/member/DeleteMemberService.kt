package com.coinkiri.application.service.member

import com.coinkiri.application.port.`in`.usecase.DeleteMember
import com.coinkiri.application.port.`in`.usecase.FindMember
import com.coinkiri.application.port.out.jpa.MemberRepository
import org.springframework.stereotype.Service

@Service
class DeleteMemberService(
    private val findMember: FindMember,
    private val memberRepository: MemberRepository
) : DeleteMember {

    override fun invoke(command: DeleteMember.Command): DeleteMember.Result {
        val member = findMember.findMemberById(command.memberId)
        memberRepository.delete(member)
        return DeleteMember.Result.Success(
            message = "회원이 삭제되었습니다 : ${member.id}, ${member.nickname}"
        )
    }
}
