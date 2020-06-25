package com.cdm.musuarios.services

import com.cdm.calumnos.models.Alumno
import com.cdm.mcommons.services.GenericServiceAPI

interface AlumnoServiceApi: GenericServiceAPI<Alumno, Long> {
    fun findByNombreOrApellido(term: String): List<Alumno>
}