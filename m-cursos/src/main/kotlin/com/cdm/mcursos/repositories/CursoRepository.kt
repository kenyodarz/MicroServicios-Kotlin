package com.cdm.mcursos.repositories

import com.cdm.mcursos.models.Curso
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CursoRepository: JpaRepository<Curso, Long> {

    @Query("select c from Curso c join fetch c.alumnos a where a.idAlumnos=?1")
    fun findCursoByAlumnoId(id: Long): Curso
}