package org.example

import kotlin.math.PI
import kotlin.math.sqrt

fun main() {
    val rect = Rectangle(
        width = 5f,
        height = 7f
    )
    println(rect)
    val rect2 = Rectangle(
        width = 5f,
        height = 7f
    )
    println(rect2)
    println(rect == rect2)

    val circle = Circle(radius = 4f)
    println(circle)

    println(sumAreas(rect,rect2, circle))
}

fun sumAreas(vararg shapes: Shape): Double {
    return shapes.sumOf { shape ->shape.area.toDouble() }
}

interface Shape {
    val area: Float
    val perimeter: Float
}

data class Rectangle(val width: Float, val height: Float): Shape {

    val diagonal = sqrt(width * width + height * height)

    override val area = width * height
    override val perimeter: Float
        get() = 2 * (width + height)
}

data class Circle(val radius: Float): Shape {

    override val area = PI.toFloat() * radius * radius
    override val perimeter = 2 * PI.toFloat() * radius
}