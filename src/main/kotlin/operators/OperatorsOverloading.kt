package operators

import oop.Color
import oop.max
import kotlin.math.sqrt


data class Vector(private val elements: List<Double>) {

    constructor(e1: Double, e2: Double) : this(listOf(e1, e2))
    constructor(vararg e: Double) : this(if (e.isNotEmpty()) e.asList() else emptyList())
    constructor(vararg e: Number) : this(if (e.isNotEmpty()) e.asList().map { it.toDouble() } else emptyList())

    fun size() = elements.size
    fun get(i: Int): Double = if (i < elements.size) elements[i] else 0.0

    fun magnitude(): Double {
        return sqrt(elements.sumOf { it * it })
    }
}

operator fun Vector.plus(other: Vector): Vector {
    val resultSize = if (this.size() > other.size()) this.size() else other.size()
    val results = mutableListOf<Double>()
    for (i in 0 until resultSize) {
        results.add(this.get(i) + other.get(i))
    }
    return Vector(results)
}

operator fun Vector.unaryMinus(): Vector {
    val result = mutableListOf<Double>()
    for (i in 0 until this.size()) {
        result.add(-this.get(i))
    }
    return Vector(result)
}

operator fun Vector.minus(other: Vector): Vector {
    return this + (-other)
}

operator fun Vector.times(other: Vector): Double {
    var result = 0.0
    for (i in 0 until size()) {
        result += (get(i) * other.get(i))
    }
    return result
}

operator fun Vector.plus(n: Number): Vector {
    val result = mutableListOf<Double>()
    for (i in 0 until size()) {
        result.add(get(i) + n.toDouble())
    }
    return Vector(result)
}

operator fun Vector.times(n: Number): Vector {
    val result = mutableListOf<Double>()
    for (i in 0 until size()) {
        result.add(get(i) * n.toDouble())
    }
    return Vector(result)
}

operator fun Number.plus(v: Vector): Vector {
    return v + this
}

operator fun Number.times(v: Vector): Vector {
    return v * this
}

operator fun Vector.compareTo(other: Vector): Int {
    val magnitudeComparison = magnitude().compareTo(other.magnitude())
    if (magnitudeComparison != 0)
        return magnitudeComparison
    // Fall back to element-wise comparison to be consistent with ==
//    for (i in 0 until max(size(), other.size())) {
//        val compareElement = get(i).compareTo(other.get(i))
//        if (compareElement!=0) return compareElement
//    }
    return 0
}

fun main() {
    val v1 = Vector(1.0, 1.0, 1.0)
    val v2 = Vector(0.0, 1.0, 2.0, 0.5)
    val v3 = - v1
    println(v1 + v2)
    println(v1 == v2)
    println(v3)
    println(v1 - v2)
    println(v1 * v2)
    println(v2 + 0.5)
    println(v3 * 2)
    println(3 + v3)
    println(2 * v2)

    var v4 = Vector(0.5, 0.5, 0.5, 1.0)
    v4 += v2
    println(v4)


    var list1 = listOf(1, 2, 3)
    val list2 = list1
    list1 += 4
    println(list1)
    println(list2)

    val list3 = mutableListOf(1, 2, 3)
    val list4 = list1
    list3 += 4
    println(list3)
    println(list4)

    val v34 = Vector(3, 4)
    val v50 = Vector(5.0, 0)
    println("Comparison")
    println(v2 < v4)
    println("||v34|| = ${v34.magnitude()}")
    println("||v50|| = ${v50.magnitude()}")
    println(v34 == v50)
    println(v34.compareTo(v50))
    println(v34 < v50)
    println(v34 <= v50 )
    println(v34 >= v50 )
    println()

    val map = mapOf(1 to "a", 2 to "b", 3 to "c")
    val (k, v) = map.entries.first()
    println(k)
    println(v)
    val entry = map.entries.last()
    println("${entry.component1()} ${entry.component2()}")
    val p = Pair(1234, "Paris")
    println("${p.component1()} ${p.component2()}")
    val t = Triple(6458769, "London", Color.ORANGE)
    println("${t.component1()} ${t.component2()} ${t.component3()}")


}
