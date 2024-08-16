package com.coinkiri.api.adapter.controller

import com.coinkiri.api.adapter.request.SignUpRequest
import com.coinkiri.application.service.auth.AuthServiceProvider
import com.coinkiri.domain.member.SocialType
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Member")
@RestController
@RequestMapping("api/v1/auth")
class AuthController(
    private val authServiceProvider: AuthServiceProvider
) {

    @Operation(summary = "소셜 로그인")
    @PostMapping("/signUp")
    fun signUp(
        @RequestBody request: SignUpRequest
    ) {
        val socialType = SocialType.valueOf(request.socialType)
        val authService = authServiceProvider.getAuthService(socialType)
        val member = authService.signUp(request.to())
    }
}
