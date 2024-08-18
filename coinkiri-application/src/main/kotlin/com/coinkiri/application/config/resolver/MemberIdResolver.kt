package com.coinkiri.application.config.resolver

import com.coinkiri.application.config.interceptor.Auth
import com.coinkiri.application.port.out.oauth2.JwtKey
import org.springframework.core.MethodParameter
import org.springframework.stereotype.Component
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer

@Component
class MemberIdResolver : HandlerMethodArgumentResolver {

    override fun supportsParameter(parameter: MethodParameter): Boolean {
        return parameter.hasParameterAnnotation(MemberId::class.java) && Long::class.java == parameter.parameterType
    }

    override fun resolveArgument(
        parameter: MethodParameter,
        mavContainer: ModelAndViewContainer?,
        webRequest: NativeWebRequest,
        binderFactory: WebDataBinderFactory?
    ): Any? {
        parameter.getMethodAnnotation(Auth::class.java)
            ?: throw IllegalStateException(
                "인증이 필요한 컨트롤러 입니다. @Auth 어노테이션을 붙여주세요."
            )

        return webRequest.getAttribute(JwtKey.MEMBER_ID, 0)
            ?: throw NoSuchElementException(
                "MEMBER_ID 를 가져오지 못했습니다. ($parameter.javaClass - $parameter.method)"
            )
    }
}
