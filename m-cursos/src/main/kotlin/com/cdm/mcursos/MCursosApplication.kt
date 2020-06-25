package com.cdm.mcursos

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@EnableEurekaClient
@SpringBootApplication
@EntityScan("com.cdm.calumnos.models","com.cdm.mcursos.models")
class MCursosApplication

fun main(args: Array<String>) {
	runApplication<MCursosApplication>(*args)
}
