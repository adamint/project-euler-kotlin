package me.circuitrcay.euler.challenges.twentySixToFifty

import me.circuitrcay.euler.Problem
import me.circuitrcay.euler.utils.isPanDigital

class Problem43 : Problem<String>() {
    override fun calculate(): Any {
        val numbers = mutableListOf<Long>()
        (1000000000..9999999999).forEach { num ->
            if (num.isPanDigital(9)) {
                val str = num.toString()
                if (str.substring(1, 4).toInt() % 2 == 0 && str.substring(2, 5).toInt() % 3 == 0 && str.substring(3, 6).toInt() % 5 == 0
                        && str.substring(4, 7).toInt() % 7 == 0 && str.substring(5, 8).toInt() % 11 == 0 && str.substring(6, 9).toInt() % 13 == 0
                        && str.substring(7, 10).toInt() % 17 == 0) numbers.add(num)
            }
            else if (num % 1000000L == 0L) println(num)
        }
        return numbers.size
    }
}