package com.cdm.mrespuestas.services

import com.cdm.mrespuestas.models.Respuesta

interface RepuestaServiceApi {
    fun saveAll(respuestas: Iterable<Respuesta>): Iterable<Respuesta>
    fun findExamenWithRespuestasByAlumno(idAlumno: Long, idExamen: Long): Iterable<Respuesta>
    fun findExamenIdsConRespuestasByAlumnos(id: Long): Iterable<Long>
}