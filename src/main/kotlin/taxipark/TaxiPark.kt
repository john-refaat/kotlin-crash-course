package taxipark

data class TaxiPark(
    val allDrivers: Set<Driver>,
    val allPassengers: Set<Passenger>,
    val trips: List<Trip>
)

data class Driver(val name: String)
data class Passenger(val name: String)

data class Trip(
    val driver: Driver,
    val passengers: Set<Passenger>,
    val duration: Int,
    val distance: Double,
    val discount: Double? = null
) {
    val cost: Double
        get() = (1 - (discount ?: 0.0)) * (duration + distance)
}

fun TaxiPark.findFakeDrivers(): Set<Driver> =
    allDrivers - trips.map { it.driver }

fun TaxiPark.findFaithfulPassengers(minTrips: Int) =
    trips.flatMap { it.passengers }
        .groupBy { passenger -> passenger }
        .filterValues { group -> group.size >= 2 }
        .keys

fun TaxiPark.findFrequentPassengers(driver: Driver) =
    trips.filter { it.driver == driver }
        .flatMap { it.passengers }
        .groupBy { passenger -> passenger }
        .filterValues { group -> group.size > 1 }
        .keys

/**
 * Passengers who most of their trips have discount
 */
fun TaxiPark.findSmartPassengers(): Set<Passenger> {
    val (tripsWithDisc, tripsWithoutDisc) = trips.partition { it.discount != null }
    return allPassengers.filter { p ->
        tripsWithDisc.count { p in it.passengers } > tripsWithoutDisc.count { p in it.passengers }
    }.toSet()
}

fun TaxiPark.findSmartPassengers1(): Set<Passenger> =
    allPassengers
        .associateWith { p -> trips.filter { p in it.passengers } }
        .filterValues { group ->
            val (withDiscount, withoutDiscount) = group.partition { it.discount != null }
            withDiscount.size > withoutDiscount.size
        }
        .keys

fun TaxiPark.findSmartPassengers2(): Set<Passenger> =
    trips.flatMap { trip -> trip.passengers.map { p -> p to trip.discount } }
        .groupBy { it.first }
        .filterValues { list ->
            val numOfDiscounts = list.count { (_, d) -> d != null }
            numOfDiscounts > (list.size - numOfDiscounts)
        }.keys

fun TaxiPark.findTheMostFrequentTripDurationPeriod(): IntRange? =
    trips.groupBy { trip ->
        val start = (trip.duration / 10) * 10
        val end = start + 9
        start..end
    }.mapValues { it.value.size }
        .maxBy { it.value }
        .key

fun TaxiPark.checkParetoPrinciple(): Boolean {
    val totalIncome = trips.sumOf { it.cost }
    val sortedDriversIncome = trips.groupBy { it.driver }
        .map { it.value.sumOf { trip -> trip.cost } }
        .sortedDescending()
    val numberOfTopDrivers = (0.2 * allDrivers.size).toInt()
    val incomeByTopDrivers = sortedDriversIncome.take(numberOfTopDrivers).sum()
    println(sortedDriversIncome)
    println(numberOfTopDrivers)
    println(incomeByTopDrivers)
    return incomeByTopDrivers >= (0.8 * totalIncome)
}

fun main() {
    val driver1 = Driver("Alice")
    val driver2 = Driver("Bob")
    val driver3 = Driver("Charlie")

    val passenger1 = Passenger("Tom")
    val passenger2 = Passenger("Jerry")
    val passenger3 = Passenger("Mia")
    val passenger4 = Passenger("Liam")
    val passenger5 = Passenger("Sophia")

    val trips = listOf(
        Trip(
            driver = driver1,
            passengers = setOf(passenger1, passenger2),
            duration = 15,
            distance = 5.0,
            discount = 0.1
        ),
        Trip(
            driver = driver1,
            passengers = setOf(passenger3),
            duration = 10,
            distance = 3.5
        ),
        Trip(
            driver = driver2,
            passengers = setOf(passenger1, passenger4),
            duration = 20,
            distance = 8.0,
            discount = 0.2
        ),
        Trip(
            driver = driver3,
            passengers = setOf(passenger2, passenger5),
            duration = 12,
            distance = 4.0
        ),
        Trip(
            driver = driver2,
            passengers = setOf(passenger3, passenger4, passenger5),
            duration = 25,
            distance = 10.0,
            discount = 0.15
        ),
        Trip(
            driver = driver1,
            passengers = setOf(passenger5, passenger1),
            duration = 18,
            distance = 6.5
        ),
        Trip(
            driver = driver2,
            passengers = setOf(passenger1, passenger3),
            duration = 9,
            distance = 5.5
        ),
        Trip(
            driver = driver3,
            passengers = setOf(passenger2, passenger4),
            duration = 22,
            distance = 7.5
        )
    )

    val taxiPark = TaxiPark(
        allDrivers = setOf(driver1, driver2, driver3),
        allPassengers = setOf(passenger1, passenger2, passenger3, passenger4, passenger5),
        trips = trips
    )

    println("TaxiPark: $taxiPark")
    println("Fake drivers: ${taxiPark.findFakeDrivers()}")

    println("Faithful Passengers: ${taxiPark.findFaithfulPassengers(2)}")


    println("Frequent Passengers with driver ${driver2.name}: ${taxiPark.findFrequentPassengers(driver2)}")

    println("Smart Passengers 0: ${taxiPark.findSmartPassengers()}")
    println("Smart Passengers 1: ${taxiPark.findSmartPassengers1()}")
    println("Smart Passengers 2: ${taxiPark.findSmartPassengers2()}")
    println("The most frequent duration range: ${taxiPark.findTheMostFrequentTripDurationPeriod()}")

    println(taxiPark.checkParetoPrinciple())
}