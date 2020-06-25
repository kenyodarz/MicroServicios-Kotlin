package com.cdm.mcommons.controllers

import com.cdm.mcommons.services.GenericServiceAPI
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.io.Serializable

@RestController
open class GenericRestController<T, ID: Serializable, S : GenericServiceAPI<T,ID>> {

    @Autowired
    var serviceAPI: S? = null

    @GetMapping("/all")
    fun getAll(): List<T> {
        return serviceAPI!!.getAll()
    }

    @GetMapping("/{id}")
    fun find(@PathVariable id: ID): T{
        return serviceAPI!!.getT(id)
    }

    @PostMapping("/save")
    fun save(@RequestBody entity : T): ResponseEntity<T>{
        val obj = serviceAPI!!.save(entity)
        return ResponseEntity(obj, HttpStatus.OK)
    }

    @GetMapping("/delete/{id}")
    fun delete(@PathVariable id: ID): ResponseEntity<T>{
        val entity: T? = serviceAPI!!.getT(id)
        if (entity != null){
            serviceAPI!!.delete(id)
        }else { return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR) }

        return ResponseEntity(entity, HttpStatus.OK)
    }

}