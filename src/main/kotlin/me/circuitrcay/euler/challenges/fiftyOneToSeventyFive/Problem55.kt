package me.circuitrcay.euler.challenges.fiftyOneToSeventyFive

import me.circuitrcay.euler.Problem
import java.math.BigInteger

class Problem55: Problem<String>() {
    override fun calculate(): Any {
        return 10000L - (1..10000).filter { it.getIterationsRequired() != -1L }.count()
    }


    fun Int.getIterationsRequired(): Long {
        var num = BigInteger.valueOf(this.toLong())
        var count = 1L
        while (true) {
            if (count > 100) return -1
            num = num.plus(num.toString().reversed().toBigInteger())
            if (num.toString() == num.toString().reversed()) return count
            else count++
        }
    }
}