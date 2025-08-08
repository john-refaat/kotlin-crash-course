package org.example.mastermind

import kotlin.math.min

fun evaluateGuess(secret: String, guess: String): Pair<Int, Int> {
    val correctPositions = secret.zip(guess).count { it.first == it.second }
//    val frequency1 = secret.groupingBy { it }.eachCount()
//    val frequency2 = guess.groupingBy { it }.eachCount()
//    val commonLetters = frequency1.entries.sumOf {
//        min(it.value, frequency2[it.key]?:0)
//    }
    val commonLetters = ('A'..'F').sumOf {
            ch -> min(secret.count { it ==  ch}, guess.count{it == ch})
    }
    val wrongPositions = commonLetters - correctPositions
    println("Correct positions: $correctPositions")
    println("Wrong positions: $wrongPositions")
    return correctPositions to wrongPositions
}

open class Animal

class Cat: Animal()
class Car

fun main() {
    evaluateGuess("AABBBC", "ABCABC")
    evaluateGuess("ABDDFE", "AAABBB")

    val list = listOf(1,2, 3, 4, 5, 6, 7)
    val n:Int = list[1]
    val m:Int? = list.getOrNull(3)
    println(n.toFloat())
    println(m ?: 0)
    println(((m?:0)+1).toFloat())
    println(m?.toFloat()?:0.0)
    println(m)
    println(m!!.toFloat())

    val animal: Animal = Cat()
    val car = Car()
    val s = (animal as Cat)
    println(s)
    val t = (car as? Cat)?:"NA"
    println(t)

    val u = ""
    println(u as? Int)
    println(u as Int?)
}