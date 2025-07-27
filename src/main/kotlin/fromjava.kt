package org.example

fun updateWeather(degrees: Int) {
    val (description, color) = when {
        degrees < 10 -> "Cold" to Color.BLUE
        degrees < 25 -> "Mild" to Color.ORANGE
        else -> "Hot" to Color.RED
    }
    println("$description, $color")
}

enum class Color {
    RED, ORANGE, BLUE
}

fun main(args: Array<String>) {
    updateWeather(5)
    updateWeather(10)
    updateWeather(25)
    updateWeather(30)
}
