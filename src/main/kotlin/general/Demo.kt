package org.example

fun displaySeparator(character: Char = '*', size: Int = 10) {
    repeat(size) {
        print(character)
    }
    println()
}

fun main() {
    displaySeparator('#', 5)
    displaySeparator('#')
    displaySeparator(size = 5)
    print("Choose your pet (Cat/Dog): ")
    val pet = when(readLine()) {
        "Cat", "cat" -> Cat()
        "Dog", "dog" -> Dog()
        else -> null
    }

    when(pet) {
        is Cat -> pet.meow()
        is Dog -> pet.woof()
    }
    
}

@JvmOverloads
fun sum(a: Int = 0, b:Int = 0, c: Int = 0) = a + b + c

interface Pet


class Cat: Pet {
    fun meow() {
        println("Meow!")
    }
}

class Dog: Pet {
    fun woof() {
        println("Woof!")
    }
}

