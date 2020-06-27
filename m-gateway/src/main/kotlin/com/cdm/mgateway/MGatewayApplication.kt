package com.cdm.mgateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@EnableEurekaClient
@SpringBootApplication
class MGatewayApplication

fun main(args: Array<String>) {
	runApplication<MGatewayApplication>(*args)
}
