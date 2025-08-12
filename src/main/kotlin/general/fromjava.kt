package general

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
    println(args)
    updateWeather(5)
    updateWeather(10)
    updateWeather(25)
    updateWeather(30)
    var languages = mutableListOf("Java", "Python")
    languages.add("Kotlin")
    var langs = listOf("Java", "Python")
    //langs.add("Kotlin")
    var ls = arrayOf("Java", "Python")
    ls[1] = "Kotlin"
    val lss = ls.plus("Scala")
    ls.forEach { println(it) }
    println(lss.toList().toString())
}
