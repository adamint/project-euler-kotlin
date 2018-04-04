package me.circuitrcay.euler.challenges.fiftyOneToSeventyFive

import me.circuitrcay.euler.Problem
import java.math.BigInteger

class Problem56:Problem<String>() {
    override fun calculate(): Any {
        var max = 0
        for (a in 2..100 step 1) {
            for (b in 2..100 step 1) {
                val localMax = BigInteger.valueOf(a.toLong()).pow(b).toString().map { it.toString().toInt() }.sum()
                if (max < localMax) max = localMax
            }
        }
        return max
    }
}