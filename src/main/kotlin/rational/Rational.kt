package rational

import java.math.BigDecimal
import java.math.BigInteger
import java.math.BigInteger.ONE
import java.math.BigInteger.ZERO

class Rational(num: BigInteger, den: BigInteger) : Comparable<Rational> {
    val numerator: BigInteger
    val denominator: BigInteger

    init {
        require(den != ZERO) { "Denominator must be non-zero" }
        val g = num.gcd(den)
        val sign = den.signum()
        numerator = (num / g) * sign.toBigInteger()
        denominator = (den / g) * sign.toBigInteger()
    }

    companion object {
        val ZERO = Rational(0, 1)
    }

    constructor(num: Int, den: Int) : this(num.toBigInteger(), den.toBigInteger())
    constructor(num: Long, den: Long) : this(num.toBigInteger(), den.toBigInteger())


    override fun toString(): String = "$numerator/$denominator"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Rational

        if (numerator != other.numerator) return false
        if (denominator != other.denominator) return false

        return true
    }

    override fun hashCode(): Int {
        var result = numerator.hashCode()
        result = 31 * result + denominator.hashCode()
        return result
    }

    override fun compareTo(other: Rational): Int {
        return (numerator * other.denominator - denominator * other.numerator).signum()
    }


}

@ConsistentCopyVisibility
data class Rational2
private constructor(val numerator: BigInteger, val denominator: BigInteger) {

    companion object {

        val ZERO = create(0, 1)

        fun create(num: BigInteger, den: BigInteger): Rational2 {
            require(den != ZERO) { "Denominator must be non-zero" }
            val g = num.gcd(den)
            val sign = den.signum().toBigInteger()
            return Rational2((num / g) * sign, (den / g) * sign)
        }

        fun create(num: Int, den: Int) = create(num.toBigInteger(), den.toBigInteger())
    }


    override fun toString(): String = "$numerator/$denominator"
}

infix fun BigInteger.divBy(denom: BigInteger) = Rational(this, denom)
infix fun Long.divBy(denom: Long) = Rational(this, denom)
infix fun Int.divBy(denom: Int) = Rational(this, denom)

infix fun Rational.divBy(denom: BigInteger): Rational =
    Rational(this.numerator, this.denominator * denom)


infix fun Rational.divBy(denom: Int) = divBy(denom.toBigInteger())
infix fun Rational.divBy(denom: Long) = divBy(denom.toBigInteger())

infix fun Rational.divBy(other: Rational): Rational =
    this * other.inverse()

operator fun Rational.unaryMinus() = -numerator divBy denominator

operator fun Rational.plus(other: Rational) =
    Rational(
        numerator * other.denominator + denominator * other.numerator,
        denominator * other.denominator
    )

operator fun Rational.minus(other: Rational) = this + (-other)

operator fun Rational.times(other: Rational) =
    (numerator * other.numerator) divBy (denominator * other.denominator)

operator fun Rational.div(other: Rational) =
    this divBy other

//operator fun Rational.compareTo(other: Rational) = (this - other).numerator.signum()

fun Rational.inverse(): Rational = denominator divBy numerator
fun Rational.toDouble(): Double = numerator.toDouble() / denominator.toDouble()


fun String.toRational(): Rational {
    fun fail():Nothing = throw IllegalArgumentException("Expected rational in the form of n/d or n, " +
                "was: ${this@toRational}")

    fun String.toBigIntegerOrFail(): BigInteger = toBigIntegerOrNull() ?: fail()

    if (!contains("/"))
        return toBigIntegerOrFail() divBy ONE
    if (count { it == '/' } > 1) fail()
    val (num, den) = replace(" ", "").split("/")
    return num.toBigIntegerOrFail() divBy den.toBigIntegerOrFail()
}


fun main() {
    val rational = Rational(2, -6)
    println(rational)
    val rational2 = Rational2.create(2, 4)
    println(rational2)

    println(Rational(1, 2) == Rational(2, 4))
    val shortNames = mapOf(
        Rational(1, 2) to "one half",
        Rational(1, 3) to "one third"
    )
    println(shortNames[Rational(2, 4)])
//    val badRational = Rational(1, 0)
//    println(badRational)

    println(Rational2.create(1, 2) == Rational2.create(2, 4))
    val shortNames2 = mapOf(
        Rational2.create(1, 2) to "one half",
        Rational2.create(1, 3) to "one third"
    )
    println(shortNames[Rational(2, 4)])
//    val badRational2 = Rational2.create(1, 0)
//    println(badRational2)

    println(Rational(0, 1))
    println(Rational(0, 2))
    println(Rational.ZERO)
    println(Rational2.ZERO)

    println(Rational.ZERO == Rational(0, 2))

    println(1 divBy 2)
    println(1000000000000000L divBy 300000000000000000L)
    println(BigInteger.ONE divBy BigInteger.TEN)
    println(Rational(1, 3) divBy Rational(1, 2))
    println(-(1 divBy 2))

    println((1 divBy 2) * (2 divBy 3))
    println((1 divBy 3) / (2 divBy 3))
    println((1 divBy 3) + (2 divBy 3))
    println((2 divBy 3) - (1 divBy 3))
    println(BigInteger.ONE.toDouble() / BigInteger.TEN.toDouble())

    println((1 divBy 2).toDouble())
    println((1 divBy 2) > (1 divBy 3))
    println((3 divBy 2) <= (5 divBy 2))
    println((7 divBy 2) < (5 divBy 2))

    println((2 divBy 5) in (1 divBy 5)..(5 divBy 5))

    println("1/3".toRational() == 1 divBy 3)
    println("1 / 2".toRational())
    println("1/3/3".toRational())


}
