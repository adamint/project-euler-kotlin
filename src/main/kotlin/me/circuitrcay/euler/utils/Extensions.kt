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

fun String.getResource(): String = Jsoup.connect(this).get().body().text()

fun print(arr: Array<Array<Int>>) {
    val sb = StringBuilder()
    arr.forEach { row -> row.forEach { sb.append("$it ") }; sb.append("\n") }
    println(sb)
}

fun generateCounterClockwiseSpiral(size: Int, prev: Array<Array<Int>>? = null): Array<Array<Int>> {
    if (size % 2 == 0) throw IllegalArgumentException("Size must be odd")
    var spiral = Array(size, { Array(size, { 1 }) })
    if (prev != null) {
        val list = mutableListOf<Array<Int>>()
        list.add(Array(size, { 0 }))
        list.addAll(prev.toMutableList())
        list.add(Array(size, { 0 }))
        for (i in 1..(list.size - 2)) {
            val temp = mutableListOf(0)
            temp.addAll(list[i].toMutableList())
            temp.add(0)
            list[i] = temp.toTypedArray()
        }
        spiral = list.toTypedArray()
    }
    var current = if (prev == null) Pair(size / 2, size / 2)
    else Pair(size - 2, 1)
    var displacement = if (prev == null) 1 else prev.size
    for (currSize in 2..size) {
        val startValue = spiral[current.first][current.second]
        var count = 1
        for (right in 1..displacement) {
            spiral[current.first][current.second + right] = startValue + count
            count++
        }
        current = Pair(current.first, current.second + displacement)
        for (up in 1..displacement) {
            spiral[current.first - up][current.second] = startValue + count
            count++
        }
        current = Pair(current.first - displacement, current.second)
        for (left in 1..(displacement + 1)) {
            spiral[current.first][current.second - left] = startValue + count
            count++
        }
        current = Pair(current.first, current.second - displacement - 1)
        for (down in 1..(displacement + 1)) {
            spiral[current.first + down][current.second] = startValue + count
            count++
        }
        if (displacement + 2 >= size) {
            var right = 1
            while (right < size) {
                spiral[size - 1][right] = startValue + count
                right++
                count++
            }
            return spiral
        }
        current = Pair(current.first + displacement + 1, current.second)
        displacement += 2
    }

    return spiral
}

fun generateClockwiseSpiral(size: Int) = generateCounterClockwiseSpiral(size).reversedArray()

fun <T> getDiagonals(arr: Array<Array<T>>): List<T> {
    val list = mutableListOf<T>()
    for (x in 0..(arr.size - 1)) {
        list.add(arr[x][x])
        if (x != arr.size / 2) list.add(arr[arr.size - 1 - x][x])
    }
    return list
}