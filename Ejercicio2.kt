package com.example.laboratorio1
import org.junit.Test

class Calculadora(
    val marca: String,
    val anVida: Int
) {
    var precio: Double = 0.0

    constructor(marca: String, anVida: Int, precio: Double) : this(marca, anVida) {
        this.precio = precio
    }

    fun sumar(a: Double, b: Double): Double {
        return a + b
    }

    fun restar(a: Double, b: Double): Double {
        return a - b
    }

    fun multiplicar(a: Double, b: Double): Double {
        return a * b
    }

    fun dividir(a: Double, b: Double): String {
        return if (b == 0.0) {
            "***No se puede dividir entre cero***"
        } else {
            (a / b).toString()
        }
    }

    fun mostrarDatos() {
        println("Marca: $marca")
        println("Años de vida: $anVida")
        println("Precio: $$precio")
    }

    fun actualizarPrecio(nuevoPrecio: Double) {
        precio = nuevoPrecio
        println("****Precio actualizado a $$precio")
    }
}

class Ejercicio2 {

    @Test
    fun pruebaCalculadora() {
        val calcu = Calculadora(
            marca = "*Casio",
            anVida = 7,
            precio = 40.0
        )

        calcu.mostrarDatos()

        println("*Suma: ${calcu.sumar(20.0, 15.0)}")
        println("*Resta: ${calcu.restar(20.0, 15.0)}")
        println("*Multiplicación: ${calcu.multiplicar(20.0, 15.0)}")
        println("*División: ${calcu.dividir(20.0, 15.0)}")

        calcu.actualizarPrecio(50.00)
        println("****Precio final: $${calcu.precio}")
    }
}
