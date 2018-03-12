package me.circuitrcay.euler.challenges.oneToTwentyFive

import me.circuitrcay.euler.Problem

class Problem4 : Problem<String>() {
    override fun calculate(): Any {
        var largest = PalindromeResult(0, 0, 0)
        for (i in 100..999) {
            for (j in 100..999) {
                if (isPal(i, j) && i * j > largest.product) largest = PalindromeResult(i, j)
            }
        }
        return "${largest.first} * ${largest.second} = ${largest.product}"
    }

    private fun isPal(i: Int, j: Int): Boolean {
        val str = (i * j).toString()
        return str.substring(0, Math.floor(str.length / 2.0).toInt()) == str.substring(Math.ceil(str.length / 2.0).toInt(), str.length).reversed()
    }

}
data class PalindromeResult(val first: Int, val second: Int, val product: Int = first * second)
