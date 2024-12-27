package com.coinkiri.application.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = ["com.coinkiri.application"], lazyInit = true)
class ApplicationConfig
