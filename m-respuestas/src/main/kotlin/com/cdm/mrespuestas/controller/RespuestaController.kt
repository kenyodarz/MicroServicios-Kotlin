package com.cdm.mrespuestas.controller

import com.cdm.mrespuestas.models.Respuesta
import com.cdm.mrespuestas.services.RespuestaServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
class RespuestaController {

    @Autowired
    val serviceApi: RespuestaServiceImpl? = null

    @PostMapping
    fun crear(@RequestBody respuestas: Iterable<Respuesta>): ResponseEntity<Any> {
        val respuestaIterable: Iterable<Respuesta> = serviceApi!!.saveAll(respuestas)
        return ResponseEntity.status(HttpStatus.CREATED).body(respuestaIterable)
    }

    @GetMapping("/alumno/{idAlumno}/examen/{idExamen}")
    fun findExamenWithRespuestasByAlumno(@PathVariable idAlumno: Long, @PathVariable idExamen: Long): ResponseEntity<*>? {
        val respuestas: Iterable<Respuesta> =
                serviceApi!!.findExamenWithRespuestasByAlumno(idAlumno, idExamen)
        return ResponseEntity.ok(respuestas)
    }

    @GetMapping("/alumno/{idAlumnos}/examenes-respondidos")
    fun findExamenIdsConRespuestasByAlumnos(@PathVariable idAlumnos: Long): ResponseEntity<Any> {
        val iterableExamen: Iterable<Long> =
                serviceApi!!.findExamenIdsConRespuestasByAlumnos(idAlumnos)
        return ResponseEntity.ok(iterableExamen)
    }

}