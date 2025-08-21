package types

import model.Session

fun main() {
    val session = Session()

    val description = session.description
    println(description)
    // NullPointException
    // Platform type (unannotated Java type): safe access ?. not required
    // println(description.length)
    println(description?.length?:"bla bla")

    val name = session.name
    println(name)
    // Nullable type. Safe access ?. is required
    println(name?.length)

    // session.description is not annotated
    val description2: String? = session.description
    // Safe access (?.) must be used because Kotlin type is Nullable.
    println(description2?.length)

    // Kotlin performs checks and will throw NPE
    // Cannot assign Java type with unknown nullability to Non-nullable kotlin type
    //val notNullDescription: String = session.description
    //println(notNullDescription)
}