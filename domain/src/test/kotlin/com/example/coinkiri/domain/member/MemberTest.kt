package com.example.coinkiri.domain.member

import com.coinkiri.domain.member.Member
import com.coinkiri.domain.member.MemberCreate
import com.coinkiri.domain.member.SocialType
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class MemberTest {

    @Test
    fun `멤버 생성 테스트`() {

        // given
        val memberCreate = MemberCreate(
            socialId = "123456",
            socialType = SocialType.KAKAO
        )

        // when
        val member = Member.from(memberCreate)

        // then
        member.socialId shouldBe "123456"
        member.socialType shouldBe SocialType.KAKAO
        //TODO : 닉네임 생성 로직에 대한 테스트 추가
        //TODO : 프로필 이미지 생성 로직에 대한 테스트 추가
        //TODO : 생성일자, 수정일자에 대한 테스트 추가 - LocalDateTime.now()를 사용하고 있어서 테스트가 어려움 -> 명세 만들고 테스트 구현체 주입
    }
}
