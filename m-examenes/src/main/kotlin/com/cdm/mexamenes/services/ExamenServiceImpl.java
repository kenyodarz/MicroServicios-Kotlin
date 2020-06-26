package com.cdm.mexamenes.services;

import com.cdm.cexamenes.models.Asignatura;
import com.cdm.mcommons.services.GenericServiceImp;
import com.cdm.cexamenes.models.Examen;
import com.cdm.mexamenes.repositories.AsignaturaRepository;
import com.cdm.mexamenes.repositories.ExamenRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamenServiceImpl extends GenericServiceImp<Examen, Long> implements ExamenServiceApi {

    @Autowired
    ExamenRepository repository;
    @Autowired
    AsignaturaRepository asignaturaRepository;

    @NotNull
    @Override
    public JpaRepository<Examen, Long> getRepository() {
        return repository;
    }

    @NotNull
    @Override
    public List<Examen> findByNombre(String term) {
        return repository.findByNombre(term);
    }

    @NotNull
    @Override
    public List<Asignatura> findAllAsignaturas() {
        return asignaturaRepository.findAll();
    }
}
