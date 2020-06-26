package com.cdm.mrespuestas.repositories

import com.cdm.mrespuestas.models.Respuesta
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface RespuestaRepository: JpaRepository<Respuesta, Long> {

    @Query("select r from Respuesta r " +
            "join fetch r.alumno a " +
            "join fetch r.pregunta p " +
            "join fetch p.examen e " +
            "where a.idAlumnos=?1 and e.idExamen=?2")
    fun findExamenWithRespuestasByAlumno(idAlumno: Long, idExamen: Long): Iterable<Respuesta>

    @Query("select e.idExamen from Respuesta r " +
            "join r.alumno a " +
            "join r.pregunta p " +
            "join p.examen e " +
            "where a.idAlumnos=?1 group by e.idExamen")
    fun findExamenIdsConRespuestasByAlumnos(id: Long): Iterable<Long>
}
