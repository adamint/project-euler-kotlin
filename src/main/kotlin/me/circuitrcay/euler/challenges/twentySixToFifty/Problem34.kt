package me.circuitrcay.euler.challenges.twentySixToFifty

import me.circuitrcay.euler.Problem

class Problem34: Problem<String>() {
    override fun calculate(): Any {
        return (3..999999).filter { isCurious(it) }.sum()
    }
    private fun isCurious(int: Int) = int.toString().map { it.toString().toInt().factorial() }.sum() == int
    private fun Int.factorial(): Int {
        var product = 1
        for (i in this downTo 2) product *= i
        return product
    }
}