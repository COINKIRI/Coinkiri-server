package com.coinkiri.api.config

import com.coinkiri.application.config.ApplicationConfig
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(
    value = [
        ApplicationConfig::class,
    ]
)
class ApiConfig
