package oop

sealed class Expr
class Num(val value: Int): Expr()
class Sum(val left: Expr, val right: Expr): Expr()

fun eval(e: Expr): Int = when (e) {
    is Num -> e.value
    is Sum -> eval(e.left) + eval(e.right)
}

class A2 {
    val i = 1

    //Nested Class (Default)
    // Equivalent to static in Java
    class B {
        fun foo() {
            // No reference to outer class
            // println(this@A)
        }
    }

    // Inner Class
    inner class C {
        fun foo() {
            // Has reference to Outer Class
            println(this@A2.i)
        }
    }
}

fun main() {
    println(eval(Sum(Sum(Num(2), Num(3)), Num(4))))
    val a = A2()
    val b = A2.B()
    val c = a.C() //Need A object to create C object
}