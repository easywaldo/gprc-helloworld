package com.example.hellogprc.config

import com.example.hellogprc.MyGrpcServer
import com.example.hellogprc.service.HelloServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GrpcConfiguration {

    @Bean
    fun helloService(): HelloServiceImpl {
        return HelloServiceImpl()
    }

    @Bean
    fun myGrpcServer(): MyGrpcServer {
        return MyGrpcServer()
    }
}