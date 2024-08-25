package com.coinkiri.common.response

import com.coinkiri.common.code.ErrorCode
import com.coinkiri.common.code.SuccessCode

data class ApiResponse<T>(val code: String, val message: String, var data: T?) {

    companion object {
        fun <T> success(data: T): ApiResponse<T> {
            return ApiResponse(SuccessCode.OK.code, SuccessCode.OK.message, data)
        }

        fun success(): ApiResponse<Any> {
            return ApiResponse(SuccessCode.OK.code, SuccessCode.OK.message, null)
        }

        fun error(errorCode: ErrorCode): ApiResponse<Any> {
            return ApiResponse(errorCode.code, errorCode.message, null)
        }

        fun error(errorCode: ErrorCode, message: String): ApiResponse<Any> {
            return ApiResponse(errorCode.code, message, null)
        }
    }
}
