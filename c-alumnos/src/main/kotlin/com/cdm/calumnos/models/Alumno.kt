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
        return if (foto != null) {this.foto.hashCode()} else null
    }


    override fun equals(obj: Any?): Boolean {
        if (this === obj) {
            return true
        }
        if (obj !is Alumno) {
            return false
        }
        return idAlumnos != null && idAlumnos == obj.idAlumnos
    }

}