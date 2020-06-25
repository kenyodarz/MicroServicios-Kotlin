package com.cdm.mexamenes.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.*
import javax.persistence.*
import kotlin.collections.ArrayList

@Entity
@Table(name = "examenes")
class Examen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idExamen: Long? = null

    @Column
    var nombre: String? = null

    @Column
    @Temporal (value = TemporalType.TIMESTAMP)
    var createAt: Date? = null

    @JsonIgnoreProperties(value = ["examen"], allowSetters = true)
    @OneToMany(mappedBy = "examen", fetch = FetchType.LAZY, cascade = [CascadeType.ALL], orphanRemoval = true)
    var preguntas: MutableList<Pregunta>? = null
        set(value) {
            value?.clear()
            value?.forEach(this::agregarPregunta)
            field = value
        }

    init {
        preguntas = ArrayList()
    }

    @PrePersist
    fun prePersist () {
        createAt = Date()
    }

    fun agregarPregunta(pregunta: Pregunta){
        preguntas!!.add(pregunta)
        pregunta.examen = this
    }

    fun removePregunta(pregunta: Pregunta){
        preguntas!!.remove(pregunta)
        pregunta.examen = null
    }
}