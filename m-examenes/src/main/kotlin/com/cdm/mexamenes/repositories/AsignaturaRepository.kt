package com.cdm.mexamenes.repositories

import com.cdm.cexamenes.models.Asignatura
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AsignaturaRepository: JpaRepository<Asignatura, Long> {
}