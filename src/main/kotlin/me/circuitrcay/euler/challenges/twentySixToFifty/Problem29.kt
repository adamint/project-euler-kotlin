package me.circuitrcay.euler.challenges.twentySixToFifty

import me.circuitrcay.euler.Problem
import java.math.BigInteger

class Problem29 : Problem<String>() {
    override fun calculate(): Any {
        return getPermutations(100, 100).size
    }

    private fun getPermutations(a: Int, b: Int): Set<BigInteger> {
        val permutations = mutableSetOf<BigInteger>()
        (2..a).forEach { base ->
            (2..b).forEach { power -> permutations.add(BigInteger.valueOf(base.toLong()).pow(power)) }
        }
        return permutations
    }
}