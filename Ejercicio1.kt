package com.example.laboratorio1
import org.junit.Test

class Computadora(

    var ram: Int, //es una variable si puede cambiar, val no cambia al darle un valor
    var almacenamiento: Int,
    var programasInstalados: List<String>,
    var sistemaOperativo: String) {

    fun computadoraEncendida(){
    println("***La computadora esta encendida***")
        }

    fun computadoraApagada(){
        println("***La computadora esta apagada***")
    }


fun actualizarVariables(nRam: Int, nAlmacenamiento: Int, nSistema: String){

   ram= nRam
   almacenamiento= nAlmacenamiento
    sistemaOperativo= nSistema

    println("=======Datos actualizados======")
    }

    fun programas(): List<String>{

        return programasInstalados.filter {it.contains(other = "2026")}
    }

}

class Ejercicio1 {

    @Test
    fun pruebaComputadora() {
        val listaProgramas = listOf(
            "Notion 2026",
            "Facebook 2024",
            "Word 2026",
            "Flo 2025",
            "Spotify 2026",
            "Wattpad 2025",
            "Excel 2020",
            "Android Studio 2026"
        )
 val compu = Computadora(
            ram = 16,
            almacenamiento = 512,
            programasInstalados = listaProgramas,
            sistemaOperativo = "Windows 10"
        )

        compu.computadoraEncendida()

        println("RAM: ${compu.ram} GB")
        println("Almacenamiento: ${compu.almacenamiento} GB")
        println("Sistema Operativo: ${compu.sistemaOperativo}")

        compu.actualizarVariables(32, 952, "Windows 11")

        println("RAM actualizada: ${compu.ram} GB")
        println("Almacenamiento actualizado: ${compu.almacenamiento} GB")
        println("Sistema Operativo actualizado: ${compu.sistemaOperativo}")

        println("Programas de este año:")
        compu.programas().forEach { println(it) }

        compu.computadoraApagada()
    }
}


