package me.circuitrcay.euler.challenges.fiftyOneToSeventyFive

import com.google.common.math.BigIntegerMath
import me.circuitrcay.euler.Problem
import java.math.BigInteger
import java.math.RoundingMode

class Problem53: Problem<String>() {
    override fun calculate(): Any {
        var counter = 0L
        (2..100).forEach { n ->
            (1..n).forEach { r ->
                if (choose(n,r) > BigInteger.valueOf(1000000)) counter++
            }
        }
        return counter
    }
    private fun choose(n: Int, r: Int) = BigIntegerMath.factorial(n).divide(BigIntegerMath.factorial(r).times(BigIntegerMath.factorial(n - r)))
}