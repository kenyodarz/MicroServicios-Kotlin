package com.cdm.mcursos.controllers

import com.cdm.calumnos.models.Alumno
import com.cdm.mcommons.controllers.GenericRestController
import com.cdm.mcursos.models.Curso
import com.cdm.mcursos.services.CursoServiceApi
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.function.Consumer

@RestController
class CursoRestController: GenericRestController<Curso, Long, CursoServiceApi>() {

    @PutMapping("/{id}/asignar-alumnos")
    fun asignarAlumno(@RequestBody alumnos: List<Alumno>, @PathVariable id: Long): ResponseEntity<Any>{

        val curso: Curso = serviceAPI!!.getT(id) ?: return ResponseEntity.notFound().build()
        alumnos.forEach(curso::addAlumno)
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.serviceAPI!!.save(curso))
    }

    @PutMapping("/{id}/eliminar-alumnos")
    fun eliminarAlumno(@RequestBody alumno: Alumno, @PathVariable id: Long): ResponseEntity<Any>{
        val curso: Curso = serviceAPI!!.getT(id) ?: return ResponseEntity.notFound().build()
        curso.removeAlumno(alumno)
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(serviceAPI!!.save(curso))
    }

    @GetMapping("/alumno/{id}")
    fun buscarAlumnoPorId(@PathVariable id:Long) : ResponseEntity<Any>{
        val curso: Curso = serviceAPI!!.findCursoByAlumnoId(id)
        return ResponseEntity.ok(curso)
    }
}