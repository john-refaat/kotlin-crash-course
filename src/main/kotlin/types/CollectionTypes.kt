package types

import kotlin.reflect.typeOf

data class Customer(val name: String)

object Shop {
    private val customers = mutableListOf<Customer>(Customer("Daphne"))
    fun getCustomers(): List<Customer> = customers
}

fun main() {
    val customers = Shop.getCustomers()
    println("customers: $customers")
    //customers.add() // No add function
    println("Java Type of customers: ${customers.javaClass}")

    val mutableCustomers: MutableList<Customer> = Shop.getCustomers().toMutableList()
    println("mutable customers: $mutableCustomers")
    mutableCustomers.add(Customer("Caroline"))
    println("mutable customers: $mutableCustomers")
    println("Shop.getCustomers(): ${Shop.getCustomers()}")
    println("customers: $customers")
    println("Java Type of mutableCustomers: ${mutableCustomers.javaClass}")
}