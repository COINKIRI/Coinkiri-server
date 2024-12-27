package com.coinkiri.redis.adapter

import com.coinkiri.application.port.out.redis.RedisHandler
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component
import java.util.concurrent.TimeUnit

@Component
class RedisHandlerAdapter(
    private val redisTemplate: RedisTemplate<String, Any>
) : RedisHandler {

    override fun set(key: String, value: Any, timeout: Long) {
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.MILLISECONDS)
    }

    override fun get(key: String): String? {
        return redisTemplate.opsForValue().get(key) as String?
    }

    override fun delete(key: String) {
        redisTemplate.delete(key)
    }
}
