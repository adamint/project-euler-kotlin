package me.circuitrcay.euler.challenges.twentySixToFifty

import me.circuitrcay.euler.Problem
import me.circuitrcay.euler.utils.isPanDigital

class Problem32 : Problem<String>() {
    override fun calculate(): Any {
        val products = mutableSetOf<Int>()
        (1..9999).forEach { one ->
            (1..9999).forEach { two ->
                if (isPanDigital(one, two)) products.add(one * two)
            }
        }
        return products.sum()
    }
}