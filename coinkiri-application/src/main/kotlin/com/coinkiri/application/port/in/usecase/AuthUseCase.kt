package com.coinkiri.application.port.`in`.usecase

import com.coinkiri.application.port.`in`.command.SignUpCommand

interface AuthUseCase {

    fun signUp(signUpCommand: SignUpCommand)
}
