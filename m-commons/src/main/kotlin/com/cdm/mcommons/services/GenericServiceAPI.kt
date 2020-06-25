package com.cdm.mcommons.services

import org.springframework.data.jpa.repository.JpaRepository
import java.io.Serializable

interface GenericServiceAPI<T, ID: Serializable> {

    fun save(entity: T): T

    fun delete (id: ID)

    fun getT (id: ID): T

    fun getAll(): List<T>

    fun getRepository(): JpaRepository<T,ID>

}