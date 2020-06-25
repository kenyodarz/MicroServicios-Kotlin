package com.cdm.mexamenes.services;

import com.cdm.mcommons.services.GenericServiceImp;
import com.cdm.mexamenes.models.Examen;
import com.cdm.mexamenes.repositories.ExamenRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ExamenServiceImpl extends GenericServiceImp<Examen, Long> implements ExamenServiceApi {

    @Autowired
    ExamenRepository repository;

    @NotNull
    @Override
    public JpaRepository<Examen, Long> getRepository() {
        return repository;
    }
}
