package com.cdm.mrespuestas.services

import com.cdm.mrespuestas.models.Respuesta
import com.cdm.mrespuestas.repositories.RespuestaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RespuestaServiceImpl: RepuestaServiceApi{

    @Autowired
    var repository: RespuestaRepository? = null

    override fun saveAll(respuestas: Iterable<Respuesta>): Iterable<Respuesta> {
        return repository!!.saveAll(respuestas)
    }

    override fun findExamenWithRespuestasByAlumno(idAlumno: Long, idExamen: Long): Iterable<Respuesta> {
        return  repository!!.findExamenWithRespuestasByAlumno(idAlumno,idExamen)
    }

    override fun findExamenIdsConRespuestasByAlumnos(id: Long): Iterable<Long> {
        return repository!!.findExamenIdsConRespuestasByAlumnos(id)
    }
}