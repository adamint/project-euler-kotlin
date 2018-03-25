package me.circuitrcay.euler.challenges.twentySixToFifty

import me.circuitrcay.euler.Problem
import me.circuitrcay.euler.utils.isPanDigital

class Problem38: Problem<String>() {
    override fun calculate(): Any {
        var curr = ""
        var max = 0
        (1..10000).forEach { num ->
            curr = num.toString() + (num * 2).toString()
            if (curr.isPanDigital() && num > max) max = num
            curr = ""
        }
        return "$max${max * 2}"
    }

}