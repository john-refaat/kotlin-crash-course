package inlinefunctions

import inlinefunctions.Status.*
import java.util.concurrent.locks.Lock
import kotlin.random.Random
import kotlin.random.nextInt

// Inline function: the compiler substitutes the body of the function instead of calling it
// No performance overhead

//takeIf returns the receiver object if it satisfies the given predicate,
//otherwise returns null

enum class Status{
    NEW, IN_PROGRESS, FIXED
}

data class Issue(val id: Int, var status: Status = NEW)

fun main() {
    val issue = Issue(Random.nextInt())
    issue.status = status()
    println(issue)
    println(issue.takeIf { it.status == FIXED })

    val issues = listOf<Issue>(Issue(Random.nextInt(), status()),
        Issue(Random.nextInt(), status()), Issue(Random.nextInt()),
        Issue(Random.nextInt(), status()))

    println(issues)
    issues.filter { it.status == IN_PROGRESS }
        .takeIf { it.isNotEmpty() }
        ?.let { println("There are some open issues") }


    //takeUnless: returns the receiver object if it does not satisfy the predicate
    val a = if (Random.nextBoolean()) "Hello" else ""
    println(a)
    println(a.takeUnless { it.isEmpty() })

    // repeat function
    repeat(4) {
        println("Kotlin!")
    }

    // with lock function
    //val l: Lock = ...
    // l.withLock { ... }
}

private fun status(): Status = if (Random.nextBoolean()) FIXED else IN_PROGRESS