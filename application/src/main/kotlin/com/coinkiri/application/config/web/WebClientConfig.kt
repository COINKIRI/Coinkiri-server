package com.coinkiri.application.config.web

import io.netty.channel.ChannelOption
import io.netty.handler.timeout.ReadTimeoutHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient
import reactor.netty.http.client.HttpClient
import reactor.netty.tcp.TcpClient
import java.util.concurrent.TimeUnit

@Configuration
class WebClientConfig {

    @Bean
    fun webClient(): WebClient {
        return WebClient.builder()
            .exchangeStrategies(ExchangeStrategies.withDefaults()) // 데이터 처리 전략 기본(JSON, XML)
            .clientConnector(ReactorClientHttpConnector( // Reactor Netty 기반의 HTTP 클라이언트 사용
                HttpClient.from(
                    TcpClient.create() // HTTP 클라이언트를 TcpClient 통해 생성
                        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000) // TCP 클라이언트 연결 타임아웃 설정
                        .doOnConnected { // 연결 후 설정
                            it.addHandlerFirst(ReadTimeoutHandler(3000, TimeUnit.MILLISECONDS)) // 연결 후 읽기 타임아웃 설정
                        }
                )
            ))
            .build()
    }
}
