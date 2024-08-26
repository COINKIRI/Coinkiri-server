package com.coinkiri.api.config

import com.coinkiri.application.config.ApplicationConfig
import com.coinkiri.oauth2.config.OAuth2Config
import com.coinkiri.persistence.config.PersistenceConfig
import com.coinkiri.redis.config.RedisConfig
import com.coinkiri.upbit.config.UpbitConfig
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(
    value = [
        ApplicationConfig::class, PersistenceConfig::class, OAuth2Config::class, RedisConfig::class, UpbitConfig::class
    ]
)
class ApiConfig
