package com.cdm.mcursos

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@EntityScan("com.cdm.calumnos.models","com.cdm.mcursos.models","com.cdm.cexamenes.models")
class MCursosApplication

fun main(args: Array<String>) {
	runApplication<MCursosApplication>(*args)
}
