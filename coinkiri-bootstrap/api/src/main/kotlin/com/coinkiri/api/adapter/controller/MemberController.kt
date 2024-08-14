package com.coinkiri.api.adapter.controller

import com.coinkiri.api.adapter.request.MemberCreateRequest
import com.coinkiri.api.adapter.response.MemberResponse
import com.coinkiri.application.member.port.`in`.usecase.MemberUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/members")
class MemberController(
    private val memberUseCase: MemberUseCase
) {

    @PostMapping("/create")
    fun create(
        @RequestBody request: MemberCreateRequest
    ): MemberResponse {
        val member = memberUseCase.create(request.to())
        return MemberResponse.from(member)
    }

}