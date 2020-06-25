package com.cdm.mexamenes.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table (name = "preguntas")
class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idPregunta: Long? = null

    @Column
    var texto: String? = null

    @JsonIgnoreProperties(value = ["preguntas"])
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "examen_id")
    var examen: Examen? = null

    override fun equals(other: Any?): Boolean {
        if (this === other){
            return true
        }

        if (other !is Pregunta ){
            return false
        }


        return idPregunta !=null && idPregunta == other.idPregunta
    }
}