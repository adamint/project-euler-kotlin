package me.circuitrcay.euler.challenges.twentySixToFifty

import me.circuitrcay.euler.Problem
import me.circuitrcay.euler.utils.generateRotationalPermutations
import me.circuitrcay.euler.utils.sieveOf

class Problem35 : Problem<String>() {
    override fun calculate(): Any {
        return 999999.circularPrimesIn()
    }

    private fun Int.circularPrimesIn(): Int {
        var count = 0
        val sievePrimes = sieveOf(this)
        (2..this).forEach {
            if (sievePrimes[it] && it.toString().generateRotationalPermutations().filter { !sievePrimes[it.toInt()] }.count() == 0)
                count++
            }
        return count
    }
}