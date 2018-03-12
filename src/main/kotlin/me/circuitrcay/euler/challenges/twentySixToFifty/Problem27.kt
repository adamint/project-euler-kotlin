package me.circuitrcay.euler.challenges.twentySixToFifty

import me.circuitrcay.euler.Problem

class Problem27 : Problem<String>() {
    override fun calculate(): Any {
        var max = 0
        var aMax = 0
        var bMax = 0
        for (a in -998..998 step 1) {
            for (b in -998..998 step 1) {
                val temp = getPrimeLength(a,b)
                if (temp > max) {
                    max = temp
                    aMax = a
                    bMax = b
                }
            }
        }
        return "$aMax * $bMax = ${aMax * bMax}"
    }

    private fun getPrimeLength(a: Int, b: Int): Int {
        var n = 0
        while (isPrime(Math.abs((n * n) + (a * n) + b))) n++
        return n
    }

    private fun isPrime(int: Int): Boolean {
        for (i in 2..(int / 2)) if (int % i == 0) return false
        return true
    }
}