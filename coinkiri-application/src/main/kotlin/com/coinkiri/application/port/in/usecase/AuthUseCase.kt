package com.coinkiri.application.port.`in`.usecase

import com.coinkiri.application.port.`in`.command.SignUpCommand
import com.coinkiri.domain.member.Member

interface AuthUseCase {

    fun signUp(signUpCommand: SignUpCommand): Member
}
