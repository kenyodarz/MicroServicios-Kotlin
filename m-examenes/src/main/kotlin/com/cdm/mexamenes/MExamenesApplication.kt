package com.cdm.mexamenes

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class MExamenesApplication

fun main(args: Array<String>) {
	runApplication<MExamenesApplication>(*args)
}
