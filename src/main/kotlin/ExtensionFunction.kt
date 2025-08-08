package org.example

fun String.repeat(n: Int): String {
    val sb = StringBuilder(n*length)
    for (i in 1..n) {
        sb.append(this)
    }
    return sb.toString()
}

open class Parent

class Child: Parent()

fun Parent.foo() = "Parent Foo"
fun Child.foo() = "Child Foo"

class A {
    fun foo() = "member"
}
fun A.foo(i:Int) = "extension $i"

//fun String.get(n: Int) = '*'

fun main() {
    println("abcd".get(1))
    fun String.lastChar() = get(length - 1)

    val c = "asdfghjkl".lastChar()
    println(c)

    println("abc".repeat(3))

    val p = Parent()
    val ch = Child()
    val p2: Parent = Child()

    println(p.foo())
    println(ch.foo())
    println(p2.foo())
    val a = A()
    println(a.foo())
    println(a.foo(12))
}