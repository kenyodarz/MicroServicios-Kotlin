package com.cdm.mcommons.controllers

import com.cdm.mcommons.services.GenericServiceAPI
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import java.io.Serializable
import javax.validation.Valid

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
    fun save(@Valid @RequestBody entity : T, result: BindingResult): ResponseEntity<Any> {
        if(result.hasErrors()) return this.validar(result)
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceAPI!!.save(entity))
    }

    @GetMapping("/delete/{id}")
    fun delete(@PathVariable id: ID): ResponseEntity<T>{
        val entity: T? = serviceAPI!!.getT(id)
        if (entity != null){
            serviceAPI!!.delete(id)
        }else { return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR) }

        return ResponseEntity(entity, HttpStatus.OK)
    }

    open fun validar(result: BindingResult):ResponseEntity<Any>{
        val errores: kotlin.collections.MutableMap<String, Any> = HashMap()
        result.fieldErrors.forEach { err ->
            run {
                errores.put(err.field, " El campo " + err.field + " " + err.defaultMessage)
            }
        }
        return ResponseEntity.badRequest().body(errores)
    }

}