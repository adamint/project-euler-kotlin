package me.circuitrcay.euler.challenges.oneToTwentyFive

import me.circuitrcay.euler.Problem

class Problem6 : Problem<String>() {
    override fun calculate(): Any {
        var numSum = 0
        var squaresSum = 0
        for (i in 1..100) {
            numSum+= i
            squaresSum+= i * i
        }
        return (numSum * numSum) - squaresSum
    }
}