package com.cdm.musuarios.repositories

import com.cdm.calumnos.models.Alumno
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface AlumnosRepository : JpaRepository <Alumno, Long> {

    @Query("select a from Alumno a where a.nombre like %?1% or a.apellido like %?1%")
    fun findByNombreOrApellido(term: String): List<Alumno>
}