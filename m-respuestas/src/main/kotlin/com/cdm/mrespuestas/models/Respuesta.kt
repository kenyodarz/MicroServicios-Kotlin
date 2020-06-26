package com.cdm.mrespuestas.models

import com.cdm.calumnos.models.Alumno
import com.cdm.cexamenes.models.Pregunta
import javax.persistence.*

@Entity
@Table(name = "respuestas")
class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idRespuesta: Long? = null

    @Column
    var texto: String? = null

    @ManyToOne(fetch = FetchType.LAZY)
    var alumno: Alumno? = null

    @OneToOne(fetch = FetchType.LAZY)
    var pregunta: Pregunta? = null
}