package me.circuitrcay.euler.challenges.twentySixToFifty

import me.circuitrcay.euler.Problem

class Problem30 : Problem<String>() {
    override fun calculate(): Any {
        return getFifthPowers().sum()
    }

    private fun getFifthPowers(): List<Int> {
        val list = mutableListOf<Int>()
        (2..4000000).forEach { num ->
            println(num)
            if (num.isSum()) list.add(num)
        }
        return list
    }

    private fun Int.isSum(): Boolean {
        var sum = 0
        toString().forEach {
            val i = it.toString().toInt()
            sum += i * i * i * i * i
        }
        return this == sum
    }
}