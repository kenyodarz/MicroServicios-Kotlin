package com.cdm.meureka

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@EnableEurekaServer
@SpringBootApplication
class MEurekaApplication

fun main(args: Array<String>) {
	runApplication<MEurekaApplication>(*args)
}
