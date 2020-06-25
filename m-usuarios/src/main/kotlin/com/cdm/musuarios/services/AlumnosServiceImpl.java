package com.cdm.musuarios.services;

import com.cdm.calumnos.models.Alumno;
import com.cdm.mcommons.services.GenericServiceImp;
import com.cdm.musuarios.repositories.AlumnosRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class AlumnosServiceImpl extends GenericServiceImp<Alumno, Long> implements AlumnoServiceApi {

    @Autowired
    private AlumnosRepository repository;

    @NotNull
    @Override
    public JpaRepository<Alumno, Long> getRepository() {
        return repository;
    }

    @NotNull
    @Override
    @Transactional(readOnly = true)
    public List<Alumno> findByNombreOrApellido(@NotNull String term) {
        return repository.findByNombreOrApellido(term);
    }
}
