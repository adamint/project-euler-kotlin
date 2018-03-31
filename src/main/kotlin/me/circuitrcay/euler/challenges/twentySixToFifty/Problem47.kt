package me.circuitrcay.euler.challenges.twentySixToFifty

import me.circuitrcay.euler.Problem
import me.circuitrcay.euler.utils.sieveOf

class Problem47 : Problem<String>() {
    override fun calculate(): Any {
        // super inefficient but a fast solution..
        val sieve = sieveOf(100000)
        var current = 1
        while (true) {
            if (current % 5000 == 0) println(current)
            val first = getPrimeFactors(current, sieve)
            val second = getPrimeFactors(current + 1, sieve)
            val third = getPrimeFactors(current + 2, sieve)
            val fourth = getPrimeFactors(current + 3, sieve)
            if (first.size != 4 || second.size != 4 || third.size != 4 || fourth.size != 4 ) {
                current++
                continue
            }
            val set = mutableSetOf<Int>()
            set.addAll(first + second + third)
            val superSet = mutableSetOf<Int>()
            superSet.addAll(first)
            superSet.addAll(second)
            superSet.addAll(third)
            if (superSet.size == set.size) return current
            current++
        }
    }

    private fun getPrimeFactors(n: Int, sieve: Array<Boolean>): List<Int> {
        val list = mutableListOf<Int>()
        for (i in 2..(n / 2)) if (n % i == 0 && sieve[i]) list.add(i)
        return list
    }
}