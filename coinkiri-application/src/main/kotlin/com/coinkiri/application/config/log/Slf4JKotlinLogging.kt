package com.coinkiri.application.config.log

import io.github.oshai.kotlinlogging.KLogger
import io.github.oshai.kotlinlogging.KotlinLogging

object Slf4JKotlinLogging {
    val <reified T> T.log: KLogger
        inline get() = KotlinLogging.logger {}
}
