package com.cdm.mcursos.models

import com.cdm.calumnos.models.Alumno
import com.cdm.cexamenes.models.Examen
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotEmpty
import kotlin.collections.ArrayList

@Entity
@Table(name = "cursos")
class Curso() {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    var id : Long? = null

    @Column
    @NotEmpty
    var nombre: String? = null

    @Column
    @Temporal(value = TemporalType.TIMESTAMP)
    var createAt: Date? = null

    @OneToMany(fetch = FetchType.LAZY)
    var alumnos: MutableList<Alumno>? = null

    @ManyToMany(fetch = FetchType.LAZY)
    var examenes: MutableList<Examen>? = null

    init {
        alumnos = ArrayList<Alumno>()
        examenes = ArrayList<Examen>()
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

    fun addExamen(examen: Examen){
        this.examenes!!.add(examen)
    }

    fun removeExamen(examen: Examen){
        this.examenes!!.remove(examen)
    }
}