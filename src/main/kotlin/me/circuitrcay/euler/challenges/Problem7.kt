package me.circuitrcay.euler.challenges

import me.circuitrcay.euler.Problem

class Problem7: Problem<String>() {
    override fun calculate(): Any {
        var currPrime = 1
        for (x in 1..10001) currPrime = getNextPrime(currPrime)
        return currPrime
    }
    private fun getNextPrime(lastPrime: Int): Int {
        var current = lastPrime + 1
        t@while (true) {
            for (x in 2..(current / 2)) if (current % x == 0){
                current++
                continue@t
            }
            return current
        }
    }
}