package com.coinkiri.api.adapter.controller

import com.coinkiri.api.adapter.request.MemberCreateRequest
import com.coinkiri.api.adapter.response.MemberResponse
import com.coinkiri.application.port.`in`.usecase.MemberUseCase
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Member")
@RestController
@RequestMapping("api/v1/members")
class MemberController(
    private val memberUseCase: MemberUseCase
) {

    @Operation(summary = "소셜 회원가입")
    @PostMapping("/create")
    fun create(
        @RequestBody request: MemberCreateRequest
    ) {

    }
}
