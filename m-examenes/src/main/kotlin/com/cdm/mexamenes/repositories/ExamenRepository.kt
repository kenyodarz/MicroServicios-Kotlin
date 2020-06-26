package com.cdm.mexamenes.repositories

import com.cdm.cexamenes.models.Examen
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ExamenRepository: JpaRepository<Examen, Long> {
    @Query("select e from Examen e where e.nombre like %?1%")
    fun findByNombre(term: String): List<Examen>
}