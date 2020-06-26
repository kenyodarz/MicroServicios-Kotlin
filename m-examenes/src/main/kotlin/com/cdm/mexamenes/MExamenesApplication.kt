package com.cdm.mexamenes

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
@EntityScan("com.cdm.cexamenes.models")
class MExamenesApplication

fun main(args: Array<String>) {
	runApplication<MExamenesApplication>(*args)
}
