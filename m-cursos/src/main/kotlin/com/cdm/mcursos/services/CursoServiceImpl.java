package com.cdm.mcursos.services;

import com.cdm.mcommons.services.GenericServiceImp;
import com.cdm.mcursos.include.RespuestaFeignClient;
import com.cdm.mcursos.models.Curso;
import com.cdm.mcursos.repositories.CursoRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CursoServiceImpl extends GenericServiceImp<Curso, Long> implements CursoServiceApi {

    @Autowired
    private CursoRepository repository;

    @Autowired
    private RespuestaFeignClient client;

    @NotNull
    @Override
    public JpaRepository<Curso, Long> getRepository() {
        return repository;
    }

    @NotNull
    @Override
    @Transactional (readOnly = true)
    public Curso findCursoByAlumnoId(long id) {
        return repository.findCursoByAlumnoId(id);
    }

    @NotNull
    @Override
    public Iterable<Long> findExamenIdsConRespuestasByAlumnos(long idAlumnos) {
        return client.findExamenIdsConRespuestasByAlumnos(idAlumnos);
    }
}
