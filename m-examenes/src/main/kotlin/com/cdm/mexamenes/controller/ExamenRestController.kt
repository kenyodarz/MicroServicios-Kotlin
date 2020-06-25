package com.cdm.mexamenes.controller

import com.cdm.mcommons.controllers.GenericRestController
import com.cdm.mexamenes.models.Examen
import com.cdm.mexamenes.models.Pregunta
import com.cdm.mexamenes.services.ExamenServiceApi
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ExamenRestController: GenericRestController<Examen, Long, ExamenServiceApi>() {

    @PutMapping("/{id}")
    fun edit(@RequestBody examen: Examen, @PathVariable id:Long): ResponseEntity<Any>{
        var optionalExamen: Examen = serviceAPI!!.getT(id) ?: return ResponseEntity.notFound().build()

        optionalExamen.nombre = examen.nombre

        optionalExamen.preguntas!!
                .stream()
                .filter { pregunta: Pregunta? -> !examen.preguntas!!.contains(pregunta) }
                .forEach {optionalExamen::removePregunta}
        optionalExamen.preguntas = examen.preguntas
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceAPI!!.save(optionalExamen))
    }
}