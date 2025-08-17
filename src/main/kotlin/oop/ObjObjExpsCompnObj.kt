package oop

// object = singleton
object KSingleton {

    fun foo() {
        println("KSingleton: Foo!")
    }

    @JvmStatic
    fun bar() {
        println("KSingleton: Bar!")
    }
}

lateinit var repo: Repository
fun registerRepository(repository: Repository) {
    repo = repository
}

fun registerTestRepository(customers: Map<Int, Customer>) {
    // object expression = anonymous class
    registerRepository(object : Repository {
        override fun getById(id: Int): Customer? {
            return customers[id]
        }

        override fun getAll(): List<Customer> {
            return customers.values.toList()
        }
    })
}

class A {
    // inner object is not possible
    // object is a singleton, while A can have many instances
    // it is not clear which instance of A should be referenced in B
    // inner object B{}

    // We can create a nested (static) object
    object B
}

class C {
    companion object {
        @JvmStatic fun foo() {
            println("C: companion obj: foo")
        }

        fun bar() {
            println("C: companion obj: bar")
        }
    }
}

fun main() {
    KSingleton.foo()
    KSingleton.bar()
    registerTestRepository(mapOf(1 to Customer("Lilly"),
        2 to Customer("Anna")))
    println(repo.getById(1))
    println(repo.getById(2))
    println(repo.getAll())

    val c = C()
    C.Companion.foo()
    C.Companion.bar()
    C.foo()
    C.bar()
    println(c)
}