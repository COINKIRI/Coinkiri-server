package com.coinkiri.application.port.out.oauth2

import jakarta.servlet.http.HttpServletRequest

interface LoginCheckHandler {

    fun getMemberId(request: HttpServletRequest): Long
}
