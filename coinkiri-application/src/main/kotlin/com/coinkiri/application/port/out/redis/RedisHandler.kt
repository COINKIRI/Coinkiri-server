package com.coinkiri.application.port.out.redis

interface RedisHandler {

    fun set(key: String, value: Any, timeout: Long)

    fun get(key: String): String?
}
