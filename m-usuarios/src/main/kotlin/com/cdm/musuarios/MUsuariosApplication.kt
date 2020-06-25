package com.cdm.musuarios

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@EnableEurekaClient
@SpringBootApplication
@EntityScan("com.cdm.calumnos.models")
class MUsuariosApplication
fun main(args: Array<String>) {
	runApplication<MUsuariosApplication>(*args)
}
