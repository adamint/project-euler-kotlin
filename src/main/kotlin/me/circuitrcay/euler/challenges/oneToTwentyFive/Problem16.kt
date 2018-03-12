package me.circuitrcay.euler.challenges.oneToTwentyFive

import me.circuitrcay.euler.Problem
import java.math.BigInteger

class Problem16: Problem<String>() {
    override fun calculate(): Any {
        val two = BigInteger.valueOf(2)
        var result = BigInteger.ONE
        for (i in 1..1000 step 1) result = result.times(two)
        val str = result.toString()
        var sum = 0L
        str.forEach { sum += it.toString().toLong() }
        return sum
    }
}