package me.circuitrcay.euler.challenges.twentySixToFifty

import me.circuitrcay.euler.Problem
import me.circuitrcay.euler.utils.generateCounterClockwiseSpiral
import me.circuitrcay.euler.utils.getDiagonals

class Problem28: Problem<String>() {
    override fun calculate(): Any {
        return getDiagonals(generateCounterClockwiseSpiral(1001)).sum()
    }
}