package com.coinkiri.persistence.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaAuditing
@EntityScan(basePackages = ["com.coinkiri.persistence.adapter.jpa.entity"])
@EnableJpaRepositories(basePackages = ["com.coinkiri.persistence"])
class JpaConfig
