package com.cdm.mexamenes.services

import com.cdm.cexamenes.models.Asignatura
import com.cdm.mcommons.services.GenericServiceAPI
import com.cdm.cexamenes.models.Examen

interface ExamenServiceApi: GenericServiceAPI<Examen, Long> {
    fun findByNombre(term: String): List<Examen>
    fun findAllAsignaturas(): List<Asignatura>
}