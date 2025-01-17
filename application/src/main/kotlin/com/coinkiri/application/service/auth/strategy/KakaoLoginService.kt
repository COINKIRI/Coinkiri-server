package com.coinkiri.application.service.auth.strategy

import com.coinkiri.application.port.`in`.usecase.CheckRegistered
import com.coinkiri.application.port.`in`.usecase.CreateMember
import com.coinkiri.application.port.`in`.usecase.CreateToken
import com.coinkiri.application.port.`in`.usecase.SocialLogin
import com.coinkiri.application.port.out.oauth2.KakaoApiCaller
import org.springframework.stereotype.Service

@Service
class KakaoLoginService(
    private val kakaoApiCaller: KakaoApiCaller,
    private val checkRegistered: CheckRegistered,
    private val createMember: CreateMember,
    private val createToken: CreateToken
) : SocialLogin {

    override fun invoke(command: SocialLogin.Command): SocialLogin.Result {
        val kakaoProfile = kakaoApiCaller.getProfile(command.token)

        val checkRegisteredCommand = CheckRegistered.Command(
            socialId = kakaoProfile.id,
            socialType = command.socialType
        )
        val member = checkRegistered.invoke(checkRegisteredCommand)
            ?: run {
                val createMemberCommand = CreateMember.Command(
                    socialId = kakaoProfile.id,
                    socialType = command.socialType,
                )
                createMember.invoke(createMemberCommand)
            }

        val createTokenCommand = CreateToken.Command(
            memberId = member.id
        )
        val token = createToken.invoke(createTokenCommand)

        return SocialLogin.Result.Success(
            accessToken = token.accessToken,
            refreshToken = token.refreshToken
        )
    }
}
