package me.circuitrcay.euler.challenges.twentySixToFifty

import me.circuitrcay.euler.Problem
import java.math.BigDecimal
import java.math.RoundingMode

class Problem26: Problem<String>() {
    override fun calculate(): Any {
        var sequenceLength = 0

        for (i in 1000 downTo 2) {
            if (sequenceLength >= i) {
                break
            }

            val foundRemainders = IntArray(i)
            var value = 1
            var position = 0

            while (foundRemainders[value] == 0 && value != 0) {
                foundRemainders[value] = position
                value *= 10
                value %= i
                position++
            }

            if (position - foundRemainders[value] > sequenceLength) {
                sequenceLength = position - foundRemainders[value]
            }
        }
        return sequenceLength
    }
}