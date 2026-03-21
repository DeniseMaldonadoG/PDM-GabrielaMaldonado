package com.example.laboratorio1

import org.junit.Test

class Estudiante(
    val nombre: String,
    val carnet: String,
    val asignatura: String
)

class Ejercicio3 {

    @Test
    fun pruebaEstudiantes() {

        val Ciclo01 = listOf(
            Estudiante("Alexa", "DM02026", "Programación de Dispositivos Moviles"),
            Estudiante("Harold", "DM02024", "Programación de Dispositivos Moviles"),
            Estudiante("Michelle", "DM02023", "Programación de Dispositivos Moviles"),
            Estudiante("Roberto", "DM02022", "Programación de Dispositivos Moviles"),
            Estudiante("Adriana", "DM02026", "Programación de Dispositivos Moviles"),
            Estudiante("Mario", "AN02023", "Analisis numerico"),
            Estudiante("Denise", "AN02021", "Analisis numerico"),
            Estudiante("David", "AN02023", "Analisis numerico"),
            Estudiante("Lucia", "AN02024", "Analisis numerico")
        )

        val estudiantesMoviles = Ciclo01.filter {
            it.asignatura == "Programación de Dispositivos Moviles"
        }

        println("******Estudiantes en la materia de Programación de Dispositivos Moviles******")

        estudiantesMoviles.forEach {
            println("Nombre: ${it.nombre}, Carnet: ${it.carnet}")
        }
    }
}
