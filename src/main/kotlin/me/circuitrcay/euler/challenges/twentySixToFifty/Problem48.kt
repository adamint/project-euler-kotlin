package me.circuitrcay.euler.challenges.twentySixToFifty

import me.circuitrcay.euler.Problem
import java.math.BigInteger

class Problem48:Problem<String>() {
    override fun calculate(): Any {
        var sum = BigInteger.ZERO
        (1..1000).forEach { sum += BigInteger.valueOf(it.toLong()).pow(it) }
        return sum.toString().substring(sum.toString().length - 10, sum.toString().length)
    }
}