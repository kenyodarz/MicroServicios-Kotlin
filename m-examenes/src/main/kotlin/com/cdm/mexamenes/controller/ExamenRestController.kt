package com.cdm.mexamenes.controller

import com.cdm.mcommons.controllers.GenericRestController
import com.cdm.cexamenes.models.Examen
import com.cdm.cexamenes.models.Pregunta
import com.cdm.mexamenes.services.ExamenServiceApi
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class ExamenRestController: GenericRestController<Examen, Long, ExamenServiceApi>() {

    @PutMapping("/edit/{id}")
    fun edit(@Valid @RequestBody examen: Examen, result: BindingResult, @PathVariable id:Long): ResponseEntity<Any>{
        if(result.hasErrors()) return this.validar(result)
        val optionalExamen: Examen = serviceAPI!!.getT(id) ?: return ResponseEntity.notFound().build()

        optionalExamen.nombre = examen.nombre

        optionalExamen.preguntas!!
                .stream()
                .filter { pregunta: Pregunta? -> !examen.preguntas!!.contains(pregunta) }
                .forEach(optionalExamen::removePreguntas)
        optionalExamen.preguntas = examen.preguntas
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceAPI!!.save(optionalExamen))
    }

    @GetMapping("/filtrar/{term}")
    fun filtrar(@PathVariable term: String): ResponseEntity<Any>{
        return ResponseEntity.ok(serviceAPI!!.findByNombre(term))
    }

    @GetMapping("/asignaturas")
    fun listarAsignaturas(): ResponseEntity<Any>{
        return ResponseEntity.ok(serviceAPI!!.findAllAsignaturas())
    }
}