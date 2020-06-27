package com.cdm.mcursos.include

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "microservice-respuestas")
interface RespuestaFeignClient {

    @GetMapping("/alumno/{idAlumnos}/examenes-respondidos")
    fun findExamenIdsConRespuestasByAlumnos(@PathVariable idAlumnos: Long):Iterable<Long>
}