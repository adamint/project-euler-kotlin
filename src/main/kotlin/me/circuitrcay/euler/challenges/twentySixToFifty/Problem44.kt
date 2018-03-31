package me.circuitrcay.euler.challenges.twentySixToFifty

import me.circuitrcay.euler.Problem
import kotlin.math.absoluteValue
import kotlin.math.roundToInt

class Problem44 : Problem<String>() {
    override fun calculate(): Any {
        // extremely inefficient but i couldn't figure out a better way.. 7.2 seconds avg solve time
        val found = mutableListOf<Long>()
        val pentagonalNumbers = pentagonalNumbers(10000)
        pentagonalNumbers.forEachIndexed { i, first ->
            pentagonalNumbers.forEach { second ->
                if (isPentagonal(first + second) && isPentagonal(first - second)) found += (first - second).absoluteValue
            }
        }

        return found.sorted()[0]
    }

    private fun isPentagonal(m: Long): Boolean {
        val num = (1.0 + Math.sqrt(1.0 - 4.0 * 3.0 * -2 * m)) / 6.0
        return num == num.toInt().toDouble()
    }

    private fun pentagonalNumbers(num: Int) = (1..num).mapIndexed { _, number -> (number * (3 * number - 1)) / 2L }
}