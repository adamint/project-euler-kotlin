package me.circuitrcay.euler.challenges.oneToTwentyFive

import me.circuitrcay.euler.Problem

class Problem10: Problem<String>() {
    override fun calculate(): Any {
        println("This will take a *while*")
        var sum = 2L
        var lastPrime = 1
        while (true) {
            val next = getNextPrime(lastPrime)
            if (next < 2000000) {
                lastPrime = next
                sum += next
            }
            else break
        }
        return sum
    }
    private fun getNextPrime(lastPrime: Int): Int {
        var current = lastPrime + 1
        w@while (true) {
            if (current % 2 == 0) {
                current++
                continue
            }
            for (x in IntProgression.fromClosedRange(3, current / 2, 2)) {
                if (current % x == 0){
                    current += 2
                    continue@w
                }
            }
            return current
        }
    }
}