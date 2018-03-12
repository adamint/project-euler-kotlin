package me.circuitrcay.euler.challenges.oneToTwentyFive

import me.circuitrcay.euler.Problem
import java.math.BigInteger

class Problem20: Problem<String>() {
    override fun calculate(): Any {
        return factorial(100).toString().map {  it.toString().toInt() }.sum()
    }
    private fun factorial(i: Int): BigInteger {
        var product = BigInteger.ONE
        for (x in i downTo 1) product = product.times(BigInteger.valueOf(x.toLong()))
        return product
    }
}