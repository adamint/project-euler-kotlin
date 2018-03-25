package me.circuitrcay.euler.challenges.twentySixToFifty

import me.circuitrcay.euler.Problem
import me.circuitrcay.euler.utils.bigInt
import me.circuitrcay.euler.utils.primes

class Problem26 : Problem<String>() {
    override fun calculate(): Any {
        val limit = 1000

        // see http://en.wikipedia.org/wiki/Repeating_decimal#Fractions_with_prime_denominators
        fun periodOfRepeatingDecimalInTheInverseOf(denominator: Long): Fraction {
            val period = (1..limit).find { bigInt(10).modPow(bigInt(it), bigInt(denominator)) == bigInt(1) }
            return Fraction(denominator, period ?: 1)
        }

        // average execution time of 47.3446 milliseconds over 10 iterations
        val result = primes().takeWhile { it < limit }.map { periodOfRepeatingDecimalInTheInverseOf(it) }.max()

        return result.denominator
    }

    data class Fraction(val denominator: Long, val period: Int)

    fun Sequence<Fraction>.max() = fold(Fraction(0.toLong(), 0)) { a, b -> if (a.period > b.period) a else b }
}