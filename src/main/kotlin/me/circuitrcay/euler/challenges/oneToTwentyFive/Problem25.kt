package me.circuitrcay.euler.challenges.oneToTwentyFive

import me.circuitrcay.euler.Problem
import java.math.BigInteger

class Problem25 : Problem<String>() {
    override fun calculate(): Any {
        val fibs = mutableListOf<BigInteger>(BigInteger.ONE, BigInteger.ONE)
        while (true) {
            if (fibs.last().toString().length >= 1000) {
                println(fibs.last())
                return fibs.size
            }
            else fibs.add(fibs.last().plus(fibs[fibs.size - 2]))
        }
    }

    private fun fib(i: Long): BigInteger {
        if (i < 3) return BigInteger.ONE
        return fib(i - 1) + fib(i - 2)
    }
}