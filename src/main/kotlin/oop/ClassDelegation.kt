package oop

data class Customer(val name: String)

interface Repository {
    fun getById(id: Int): Customer?
    fun getAll(): List<Customer>
}

interface Logger {
    fun logAll()
}

class RepositoryImpl(): Repository {
    val data = mapOf(1 to Customer("John"), 2 to Customer("Mary"))
    override fun getById(id: Int): Customer? {
        return data[id]
    }

    override fun getAll(): List<Customer> {
        return data.values.toList()
    }
}

class LoggerImpl(): Logger {
    override fun logAll() {
        println("Logging")
    }
}

// With Delegation
class Controller(
    repository: Repository,
    logger: Logger
): Repository by repository, Logger by logger


// Inheritance Without Delegation
class Controller2: Repository, Logger {
    override fun getById(id: Int): Customer? {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<Customer> {
        TODO("Not yet implemented")
    }

    override fun logAll() {
        TODO("Not yet implemented")
    }

}

// Composition
class Service(val repository: Repository, val logger: Logger) {
    fun getById(id: Int): Customer {
        val customer = repository.getById(id)
        logger.logAll()
        if (customer == null)
            throw IllegalArgumentException()
        return customer
    }

    fun getAll(): List<Customer> {
        logger.logAll()
        return repository.getAll()
    }

}

fun main() {
    val controller = Controller(RepositoryImpl(), LoggerImpl())
    println(controller.getById(1))
    println(controller.getById(2))
    println(controller.getAll())
    controller.logAll()

    val service = Service(RepositoryImpl(), LoggerImpl())
    println(service.getById(1))
    println(service.getById(2))
    println(service.getAll())
}