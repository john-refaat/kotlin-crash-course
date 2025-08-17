package oop

import oop.Color.*

enum class Color(val r: Int, val g: Int, val b: Int) {
    BLUE(0, 0, 255), ORANGE(255, 165, 0), RED(255, 0, 0);

    fun rgb() = (r*256 + g) * 256 + b
}

fun getDescription(color: Color) =
    when(color) {
        BLUE -> "Cold"
        ORANGE -> "Mild"
        RED -> "Hot"
    }

fun main() {
    println(BLUE.rgb())
    println(BLUE.r)
    println(ORANGE.rgb())
    println(ORANGE.g)
    println(RED.r)
    println(RED.r)
}