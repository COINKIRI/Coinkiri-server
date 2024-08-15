package com.coinkiri.application.config.swagger

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {
    companion object {
        private const val TITLE = "Coinkiri API Server"
        private const val DESCRIPTION = "Coinkiri API Docs"
        private const val VERSION = "1.0.0"
    }

    @Bean
    fun openAPI(): OpenAPI {
        val info = Info()
            .title(TITLE)
            .description(DESCRIPTION)
            .version(VERSION)

        return OpenAPI()
            .info(info)
    }
}