package com.cdm.mcommons.services

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service
import java.io.Serializable
import java.util.function.Consumer

@Service
abstract class GenericServiceImp<T, ID : Serializable> : GenericServiceAPI<T, ID> {

    override fun save(entity: T): T {
        return getRepository().save(entity)
    }

    override fun delete(id: ID) {
        return getRepository().deleteById(id)
    }

    override fun getT(id: ID): T {
        // Obtenemos un Optional
        val optional = getRepository().findById(id)
        // Retornamos Null en caso de no se encontrada la respuesta
        return optional.orElse(null)
    }

    override fun getAll(): List<T> {
        val returnList: MutableList<T> = ArrayList()
        getRepository().findAll().forEach(Consumer { t: T -> returnList.add(t) })
        return returnList
    }

    abstract override fun getRepository(): JpaRepository<T, ID>
}