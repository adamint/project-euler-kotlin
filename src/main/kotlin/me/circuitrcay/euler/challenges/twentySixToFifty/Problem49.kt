package me.circuitrcay.euler.challenges.twentySixToFifty

import me.circuitrcay.euler.Problem
import me.circuitrcay.euler.utils.permutationOf
import me.circuitrcay.euler.utils.sieveOf

class Problem49 : Problem<String>() {
    override fun calculate(): Any {
        val sieve = sieveOf(9999)
        (1000..9999).forEach { start ->
            (1..9999).forEach { increase ->
                if (start + 2 * increase < 10000 && sieve[start] && sieve[start + increase] && sieve[start + 2 * increase]) {
                    if (start.permutationOf(start + increase, start + 2 * increase))
                        println(start.toString() + (start + increase).toString() + (start + 2 * increase).toString())
                }
            }
        }
        return "look up ^_^"
    }

}