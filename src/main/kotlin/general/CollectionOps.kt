package general

import java.util.Vector

data class Hero(
    val name: String,
    val age: Int,
    val gender: Gender?
)

enum class Gender {MALE, FEMALE}

fun postponeComputation(n: Int, runnable: Runnable) {
    Thread.sleep(1000)
    runnable.run()
}

fun main() {
    val heroes = listOf(
        Hero("The Captain", 60, Gender.MALE),
        Hero("Frenchy", 42, Gender.MALE),
        Hero("The Kid", 9, null),
        Hero("Lady Lauren", 29, Gender.FEMALE),
        Hero("First Mate", 29, Gender.MALE),
        Hero("Sir Stephen", 37, Gender.MALE)
        )
    println(heroes.last().name)
    println(heroes.firstOrNull{it.age==30}?.name)
    //println(heroes.first{it.age == 30})
    println(heroes.map{it.age}.distinct().size)
    println(heroes.filter { it.age < 30 }.map { it.name to it.age })
    val (young, old) = heroes.partition { it.age < 30 }
    println(young.map { it.name to it.age })
    println(old.map {it.name to it.age})

    println(heroes.maxBy { it.age })
    println(heroes.maxWith { x, y -> x.age - y.age })
    println(heroes.all { it.age < 50 })
    println(heroes.any { it.gender == Gender.FEMALE })

    val groupByAge = heroes.groupBy { it.age }
    println(groupByAge.map { (key, value) -> key to value.map { it.name } })

    println(groupByAge.maxBy { (_, value) ->  value.size}.key)

    val associateByName = heroes.associateBy { it.name }
    println(associateByName)
    println(associateByName["Frenchy"]?.age)
    //println(associateByName.getValue("Unknown"))
    println(associateByName.getOrElse("Unknown") {"Default Hero"})

    val mapByName = heroes.associate { it.name to it.age }
    println(mapByName)

    val allPossiblePairs = heroes.flatMap {first -> heroes.map{ second -> first to second}}
    println(allPossiblePairs.map { (first, second) -> first.name to second.name })
    val(first, second) = allPossiblePairs.maxBy { it.first.age - it.second.age }
    println(first.name)
    println(second.name)

    run {println("Lambda!")}

    val runnable = Runnable{println(42)}
    postponeComputation(2000, runnable)

    postponeComputation(2000) { println("Running!") }

}