package com.cdm.mcursos.services

import com.cdm.mcommons.services.GenericServiceAPI
import com.cdm.mcursos.models.Curso

interface CursoServiceApi : GenericServiceAPI<Curso, Long> {
    fun findCursoByAlumnoId(id: Long): Curso
}

