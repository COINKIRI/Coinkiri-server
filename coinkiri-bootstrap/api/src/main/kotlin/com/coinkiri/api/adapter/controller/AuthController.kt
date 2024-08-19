package com.coinkiri.api.adapter.controller

import com.coinkiri.api.adapter.request.SocialLoginRequest
import com.coinkiri.api.adapter.request.TokenRequest
import com.coinkiri.api.adapter.response.SocialLoginResponse
import com.coinkiri.api.adapter.response.TokenResponse
import com.coinkiri.application.config.interceptor.Auth
import com.coinkiri.application.config.resolver.MemberId
import com.coinkiri.application.port.`in`.usecase.ReissueToken
import com.coinkiri.application.port.`in`.usecase.SocialLogin
import com.coinkiri.application.port.`in`.usecase.SocialLogout
import com.coinkiri.application.service.auth.SocialLoginProvider
import com.coinkiri.domain.member.SocialType
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Tag(name = "Member")
@RestController
@RequestMapping("api/v1/auth")
class AuthController(
    private val socialLoginProvider: SocialLoginProvider,
    private val reissueToken: ReissueToken,
    private val socialLogout: SocialLogout
) {

    @Operation(summary = "소셜 회원가입/로그인")
    @PostMapping("/login")
    fun socialLogin(
        @RequestHeader("Authorization") authorizationHeader: String,
        @RequestBody request: SocialLoginRequest
    ): ResponseEntity<SocialLoginResponse> {
        val token = authorizationHeader.removePrefix("Bearer ").trim()

        val socialLoginCommand = SocialLogin.Command(
            token = token,
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

    @Operation(summary = "소셜 로그아웃")
    @PostMapping("/logout")
    @Auth
    fun socialLogout(
        @MemberId memberId: Long
    ): ResponseEntity<String> {
        val socialLogoutCommand = SocialLogout.Command(
            memberId = memberId
        )

        return when (
            val result: SocialLogout.Result = socialLogout.invoke(socialLogoutCommand)
        ) {
            is SocialLogout.Result.Success -> {
                val message = result.message
                ResponseEntity.ok(message)
            }
        }
    }

    @Operation(summary = "회원 탈퇴(삭제)")
    @DeleteMapping("/delete")
    @Auth
    fun deleteMember(
        @MemberId memberId: Long
    ): ResponseEntity<String> {
        val socialLogoutCommand = SocialLogout.Command(
            memberId = memberId
        )

        return when (
            val result: SocialLogout.Result = socialLogout.invoke(socialLogoutCommand)
        ) {
            is SocialLogout.Result.Success -> {
                val message = result.message
                ResponseEntity.ok(message)
            }
        }
    }
}
