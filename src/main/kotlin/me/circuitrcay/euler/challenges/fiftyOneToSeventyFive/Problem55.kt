package me.circuitrcay.euler.challenges.fiftyOneToSeventyFive

import me.circuitrcay.euler.Problem
import java.math.BigInteger

class Problem55: Problem<String>() {
    override fun calculate(): Any {
        return 10677.getIterationsRequired()
    }


    fun Int.getIterationsRequired(): Long {
        val num = BigInteger.valueOf(this.toLong())
        var multiplier = 2L
        while (true) {
            val product = num.times(BigInteger.valueOf(multiplier)).toString()
            if (product == product.reversed()) return multiplier - 1
            multiplier++
        }
    }
}