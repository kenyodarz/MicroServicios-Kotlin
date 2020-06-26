package com.cdm.mrespuestas

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@EnableEurekaClient
@SpringBootApplication
@EntityScan("com.cdm.calumnos.models","com.cdm.mrespuestas.models","com.cdm.cexamenes.models")
class MRespuestasApplication

fun main(args: Array<String>) {
	runApplication<MRespuestasApplication>(*args)
}
