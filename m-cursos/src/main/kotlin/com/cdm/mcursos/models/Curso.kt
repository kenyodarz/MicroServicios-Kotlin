package com.cdm.mcursos.models

import com.cdm.calumnos.models.Alumno
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "cursos")
class Curso() {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    var id : Long? = null

    @Column
    var nombre: String? = null

    @Column
    @Temporal(value = TemporalType.TIMESTAMP)
    var createAt: Date? = null

    @OneToMany(fetch = FetchType.LAZY)
    var alumnos: MutableList<Alumno>? = null

    init {
        alumnos = ArrayList<Alumno>()
    }

    @PrePersist
    fun prePersist(){
        createAt = Date()
    }

    fun addAlumno(alumno: Alumno){
        this.alumnos!!.add(alumno)
    }

    fun removeAlumno(alumno: Alumno){
        this.alumnos!!.remove(alumno)
    }
}