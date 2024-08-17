package com.coinkiri.application.port.`in`.usecase

import com.coinkiri.application.port.`in`.command.SignUpCommand
import com.coinkiri.domain.member.Member

interface SocialLogin {

    fun socialLogin(signUpCommand: SignUpCommand): Member
}
