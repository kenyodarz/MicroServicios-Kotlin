package com.cdm.musuarios.controllers

import com.cdm.calumnos.models.Alumno
import com.cdm.mcommons.controllers.GenericRestController
import com.cdm.musuarios.services.AlumnoServiceApi
import org.springframework.core.io.ByteArrayResource
import org.springframework.core.io.Resource
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import javax.validation.Valid

@RestController
class AlumnoRestController : GenericRestController<Alumno, Long, AlumnoServiceApi>() {

    @PostMapping("/save-with-photo")
    fun saveWithPhoto(@Valid alumno: Alumno,result: BindingResult ,
                      @RequestParam archivo: MultipartFile): ResponseEntity<Alumno> {
        if (!archivo.isEmpty) {
            alumno.foto = archivo.bytes
        }
        val obj = serviceAPI!!.save(alumno)
        return ResponseEntity(obj, HttpStatus.OK)
    }

    @GetMapping("/filtrar/{term}")
    fun filtrar(@PathVariable term: String): ResponseEntity<List<Alumno>> {
        return ResponseEntity((serviceAPI!!.findByNombreOrApellido(term)), HttpStatus.OK)
    }

    @GetMapping("/uploads/img/{id}")
    fun viewPhoto(@PathVariable id: Long): ResponseEntity<Any> {

        val alumno: Alumno? = serviceAPI!!.getT(id)

        if (alumno?.foto == null) return ResponseEntity.notFound().build()

        val imagen: Resource = ByteArrayResource(alumno.foto)

        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imagen)

    }

    @PutMapping("/edit-with-photo/{id}")
    fun editWithPhoto(@Valid alumno: Alumno,result: BindingResult ,
                      @RequestParam archivo: MultipartFile,
                      @PathVariable id: Long  ): ResponseEntity<Any>{
        val optAlumno: Alumno = serviceAPI!!.getT(id) ?: return ResponseEntity.notFound().build()

        optAlumno.apellido = alumno.apellido
        optAlumno.nombre = alumno.nombre
        optAlumno.email = alumno.email

        if (!archivo.isEmpty) {
            optAlumno.foto = archivo.bytes
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(serviceAPI!!.save(optAlumno))
    }
}