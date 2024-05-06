package com.example.hellogprc.service


import org.lognet.springboot.grpc.GRpcService
import kotlin.coroutines.EmptyCoroutineContext
import io.grpc.examples.helloworld.GreeterGrpcKt
import io.grpc.examples.helloworld.HelloReply
import io.grpc.examples.helloworld.HelloRequest

@GRpcService
class HelloServiceImpl : GreeterGrpcKt.GreeterCoroutineImplBase(
    coroutineContext = EmptyCoroutineContext
) {
    override suspend fun sayHello(request: HelloRequest): HelloReply =
        HelloReply.newBuilder()
            .apply {
                message = "Hello ${request.name}"
            }
            .build()
}