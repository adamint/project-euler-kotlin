package me.circuitrcay.euler.challenges.twentySixToFifty

import me.circuitrcay.euler.Problem
import me.circuitrcay.euler.utils.sieveOf

class Problem37 : Problem<String>() {
    override fun calculate(): Any {
        val sieve = sieveOf(999999)
        return (10..999999).filter { it.isPermutationsPrime(sieve) }.sum()
    }

    private fun Int.isPermutationsPrime(sieve: Array<Boolean>): Boolean {
        var left = this
        var right = this
        do {
            if (!sieve[left] || !sieve[right]) return false
            left /= 10
            if (right >= 10) right = right.toString().substring(1).toInt()
        } while (left != 0)
        return true
    }
}