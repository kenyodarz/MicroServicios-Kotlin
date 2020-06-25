package com.cdm.musuarios.controllers

import com.cdm.calumnos.models.Alumno
import com.cdm.mcommons.controllers.GenericRestController
import com.cdm.musuarios.services.AlumnoServiceApi
import org.springframework.core.io.ByteArrayResource
import org.springframework.core.io.Resource
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
class AlumnoRestController : GenericRestController<Alumno, Long, AlumnoServiceApi>() {

    @PostMapping("/save-with-photo")
    fun saveWithPhoto(alumno: Alumno, @RequestParam archivo: MultipartFile): ResponseEntity<Alumno> {
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
}