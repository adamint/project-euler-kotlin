package me.circuitrcay.euler.challenges.twentySixToFifty

import me.circuitrcay.euler.Problem
import me.circuitrcay.euler.utils.isPanDigital
import me.circuitrcay.euler.utils.sieveOf

class Problem41:Problem<String>() {
    override fun calculate(): Any {
        val size = 10000000
        val primes = sieveOf(size)
        var num = 0
        primes.forEachIndexed { i, b -> if (b && i.toString().isPanDigital(i.toString().length) && i > num) num = i }
        return num
    }
}