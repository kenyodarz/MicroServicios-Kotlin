package com.cdm.calumnos.models

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.Type
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "alumnos")
class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idAlumnos: Long? = null

    @Column
    var nombre: String? = null

    @Column
    var apellido: String? = null

    @Column
    var email: String? = null

    @Column
    @Temporal (TemporalType.TIMESTAMP)
    var createAt: Date? = null

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    @JsonIgnore
    var foto = byteArrayOf()

    @PrePersist
    fun prePersist(){
        createAt = Date()
    }

    fun getFotoHashCode(): Int? {
        return this.foto.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Alumno) return false

        return idAlumnos != null && idAlumnos == other.idAlumnos
    }

}