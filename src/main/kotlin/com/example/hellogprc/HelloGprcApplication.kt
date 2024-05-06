package com.example.hellogprc

import com.example.hellogprc.service.HelloServiceImpl
import io.grpc.ServerBuilder
import io.grpc.protobuf.services.ProtoReflectionService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HelloGprcApplication

fun main(args: Array<String>) {
	//	runApplication<HelloGprcApplication>(*args)
	val context = runApplication<HelloGprcApplication>(*args)
	val grpcServer = context.getBean(MyGrpcServer::class.java)
	grpcServer.start()
}

class MyGrpcServer {
	fun start() {
		val server = ServerBuilder.forPort(6565) // gRPC 서버 포트 설정
			.addService(HelloServiceImpl()) // gRPC 서비스 추가
			.addService(ProtoReflectionService.newInstance())
			.build()

		server.start()
		server.awaitTermination()
	}
}
