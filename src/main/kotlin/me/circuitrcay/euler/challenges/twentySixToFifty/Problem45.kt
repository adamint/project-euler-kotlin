package me.circuitrcay.euler.challenges.twentySixToFifty

import me.circuitrcay.euler.Problem

class Problem45 : Problem<String>() {
    override fun calculate(): Any {
        var current = 1L
        while (true) {
            val triangleNumber = current * (current + 1) / 2
            val isPentagonal = (1.0 + Math.sqrt(1.0 - 4.0 * 3.0 * -2 * triangleNumber)) / 6.0
            if (isPentagonal.toInt().toDouble() != isPentagonal) {
                current++
                continue
            }
            val isHexagonal = (1.0 + Math.sqrt(1.0 - 4.0 * 2.0 * -1 * triangleNumber)) / 4.0
            if (isHexagonal.toInt().toDouble() == isHexagonal && triangleNumber > 40755) return triangleNumber
            current++
        }
    }

    private fun triangleNumbers(num: Int) = (1..num).mapIndexed { _, number -> (number * (number + 1)) / 2L }
}