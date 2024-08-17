package com.coinkiri.api.adapter.controller

import com.coinkiri.api.adapter.request.SocialLoginRequest
import com.coinkiri.api.adapter.request.TokenRequest
import com.coinkiri.api.adapter.response.SocialLoginResponse
import com.coinkiri.api.adapter.response.TokenResponse
import com.coinkiri.application.port.`in`.usecase.ReissueToken
import com.coinkiri.application.port.`in`.usecase.SocialLogin
import com.coinkiri.application.service.auth.SocialLoginProvider
import com.coinkiri.domain.member.SocialType
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Member")
@RestController
@RequestMapping("api/v1/auth")
class AuthController(
    private val socialLoginProvider: SocialLoginProvider,
    private val reissueToken: ReissueToken
) {

    @Operation(summary = "소셜 회원가입/로그인")
    @PostMapping("/login")
    fun socialLogin(
        @RequestBody request: SocialLoginRequest
    ): ResponseEntity<SocialLoginResponse> {
        val socialLoginCommand = SocialLogin.Command(
            token = request.token,
            socialType = SocialType.valueOf(request.socialType),
            nickname = request.nickname,
        )
        val socialLoginService = socialLoginProvider.getAuthService(socialLoginCommand.socialType)

        return when (
            val result: SocialLogin.Result = socialLoginService.invoke(socialLoginCommand)
        ) {
            is SocialLogin.Result.Success -> {
                val body = SocialLoginResponse.Success(
                    accessToken = result.accessToken,
                    refreshToken = result.refreshToken,
                )
                ResponseEntity.ok(body)
            }
        }
    }

    @Operation(summary = "토큰 갱신")
    @PostMapping("/refresh")
    fun reissueToken(
        @RequestBody request: TokenRequest
    ): ResponseEntity<TokenResponse> {
        val reissueTokenCommand = ReissueToken.Command(
            accessToken = request.accessToken,
            refreshToken = request.refreshToken,
        )

        return when (
            val result: ReissueToken.Result = reissueToken.invoke(reissueTokenCommand)
        ) {
            is ReissueToken.Result.Success -> {
                val body = TokenResponse.Success(
                    accessToken = result.accessToken,
                    refreshToken = result.refreshToken,
                )
                ResponseEntity.ok(body)
            }

            is ReissueToken.Result.Failure -> {
                val message = TokenResponse.Failure(
                    message = result.message
                )
                ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(message)
            }
        }
    }
}
