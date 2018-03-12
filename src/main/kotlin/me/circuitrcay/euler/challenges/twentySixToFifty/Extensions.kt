package me.circuitrcay.euler.challenges.twentySixToFifty

import java.math.BigInteger

fun <T: Number> bigInt(n: T) = BigInteger(n.toString())
private inline fun Long.isEven() = (this % 2) == 0L
private fun Long.isPrime() = this > 1 && smallestPrimeFactor() == null
fun Int.smallestPrimeFactor() = toLong().smallestPrimeFactor()?.toInt()
private fun Long.smallestPrimeFactor() = (2..Math.sqrt(toDouble()).toLong()).find { this % it == 0.toLong() }

fun primes(): Sequence<Long> = generateSequence(2L) { previous ->
    var number = previous + if (previous.isEven()) 1 else 2
    while (!number.isPrime()) number += 2
    number
}