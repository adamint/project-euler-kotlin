package me.circuitrcay.euler.utils

import org.apache.commons.collections4.iterators.PermutationIterator
import org.jsoup.Jsoup
import java.math.BigInteger

fun <T : Number> bigInt(n: T) = BigInteger(n.toString())
private fun Long.isEven() = (this % 2) == 0L
private fun Long.isPrime() = this > 1 && smallestPrimeFactor() == null
fun Int.smallestPrimeFactor() = toLong().smallestPrimeFactor()?.toInt()
private fun Long.smallestPrimeFactor() = (2..Math.sqrt(toDouble()).toLong()).find { this % it == 0.toLong() }

fun primes() = generateSequence(2L) { previous ->
    var number = previous + if (previous.isEven()) 1 else 2
    while (!number.isPrime()) number += 2
    number
}

fun String.generatePermutations(): List<String> {
    val permutations = mutableListOf<String>()
    val chars = toCharArray()
    val iterator = PermutationIterator(chars.toList())
    while (iterator.hasNext()) permutations.add(iterator.next().joinToString(""))
    return permutations
}

fun String.generateRotationalPermutations(): List<String> {
    val list = mutableListOf<String>()
    val chars = toCharArray()
    (1..(chars.size)).forEach {
        list.add(chars.joinToString(""))
        val tempFirst = chars[0]
        for (i in 1..(chars.size - 1) step 1) chars[i - 1] = chars[i]
        chars[chars.size - 1] = tempFirst
    }
    return list
}

fun sieveOf(num: Int): Array<Boolean> {
    val primes = Array(num + 1, { true })
    primes[0] = false
    primes[1] = false
    for (i in 2..(num / 2) step 1) for (multiplier in (i * 2)..num step i) primes[multiplier] = false
    return primes
}

fun Array<Boolean>.convertSieveToPlaces() = mapIndexed { index, b -> if (!b) -1 else index }.filter { it != -1 }

fun String.isPalindrome(): Boolean = this == reversed()

fun isPanDigital(x: Int, y: Int): Boolean {
    val str = x.toString() + y.toString() + (x * y).toString()
    if (str.length != 9) return false;
    val nums = Array(9, { false })
    (1..9).forEach { if (str.contains(it.toString())) nums[it - 1] = true }
    return nums.filter { it }.count() == 9
}

fun String.isPanDigital(n: Int? = null) = length == n ?: 9 && contains(1, n ?: 9)
fun Long.isPanDigital(n: Int? = null) = toString().length == n ?: 9 && toString().contains(0, n ?: 9)
fun String.contains(start: Int, end: Int): Boolean {
    for (i in start..end step 1) if (!contains(i.toString())) return false
    return true
}

fun Int.permutationOf(vararg ints: Int) = toLong().permutationOf(*ints.map { it.toLong() }.toLongArray())

fun Long.permutationOf(vararg longs: Long): Boolean {
    if (longs.map { it.toString().length }.filter { it != toString().length }.count() > 0) return false
    longs.map { it.toString() }.forEach { long ->
        toString().forEach { if (!long.contains(it)) return false }
        long.map { it.toString() }.forEach { against ->
            against.forEach { if (!long.contains(it)) return false }
        }
    }
    return true
}

fun Char.alphabeticalPosition(): Int {
    return when (this) {
        'a' -> 1
        'b' -> 2
        'c' -> 3
        'd' -> 4
        'e' -> 5
        'f' -> 6
        'g' -> 7
        'h' -> 8
        'i' -> 9
        'j' -> 10
        'k' -> 11
        'l' -> 12
        'm' -> 13
        'n' -> 14
        'o' -> 15
        'p' -> 16
        'q' -> 17
        'r' -> 18
        's' -> 19
        't' -> 20
        'u' -> 21
        'v' -> 22
        'w' -> 23
        'x' -> 24
        'y' -> 25
        'z' -> 26
        else -> -9999999
    }
}

fun triangleNumbersOf(num: Int): List<Int> {
    val triangleNumbers = mutableListOf<Int>()
    (1..num).forEach { triangleNumbers.add((0.5f * it.toFloat() * (it + 1).toFloat()).toInt()) }
    return triangleNumbers
}

fun String.getResource() = Jsoup.connect(this).get().body().text()