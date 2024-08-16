package com.coinkiri.api.config

import com.coinkiri.application.config.ApplicationConfig
import com.coinkiri.oauth2.config.OAuth2Config
import com.coinkiri.persistence.config.PersistenceConfig
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(
    value = [
        ApplicationConfig::class, PersistenceConfig::class, OAuth2Config::class
    ]
)
class ApiConfig
