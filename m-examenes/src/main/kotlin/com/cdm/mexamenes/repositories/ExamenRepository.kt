package com.cdm.mexamenes.repositories

import com.cdm.mexamenes.models.Examen
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ExamenRepository: JpaRepository<Examen, Long> {
}