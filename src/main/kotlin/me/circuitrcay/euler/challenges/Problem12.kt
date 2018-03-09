package me.circuitrcay.euler.challenges

import me.circuitrcay.euler.Problem

class Problem12: Problem<String>() {
    override fun calculate(): Any {
        return 0
    }
    fun getFactors(n: Int): Int {
        return 0
    }
    fun gen(n: Int): Int {
        var sum = 0
        for (x in 1..n) sum += x
        return sum
    }
}