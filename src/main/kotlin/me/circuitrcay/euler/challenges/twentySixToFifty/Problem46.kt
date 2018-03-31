package me.circuitrcay.euler.challenges.twentySixToFifty

import me.circuitrcay.euler.Problem
import me.circuitrcay.euler.utils.sieveOf

class Problem46 : Problem<String>() {
    override fun calculate(): Any {
        val primes = sieveOf(100000)
        var i = 9
        while (true) {
            if (primes.getOrElse(i, {true})) {
                i += 2
                continue
            }
            var found = false
            for ((index, prime) in primes.withIndex()) {
                if (prime) {
                    val calc = Math.sqrt((i - index) / 2.0)
                    if (calc.toInt().toDouble() == calc) {
                        found = true
                        break
                    }
                }
            }
            if (!found) return i
            i += 2
        }
    }
}