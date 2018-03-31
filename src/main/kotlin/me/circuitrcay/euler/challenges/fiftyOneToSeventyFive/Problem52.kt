package me.circuitrcay.euler.challenges.fiftyOneToSeventyFive

import me.circuitrcay.euler.Problem
import me.circuitrcay.euler.utils.permutationOf

class Problem52: Problem<String>() {
    override fun calculate(): Any {
        var current = 1L
        while (true) {
            if (current % 10000 == 0L) println(current)
            if (current.permutationOf(current * 2, current * 3, current * 4, current * 5, current * 6)) return current
            current++
        }
    }
}