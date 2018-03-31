package me.circuitrcay.euler.challenges.fiftyOneToSeventyFive

import me.circuitrcay.euler.Problem
import me.circuitrcay.euler.utils.convertSieveToPlaces
import me.circuitrcay.euler.utils.sieveOf

class Problem51 : Problem<String>() {
    override fun calculate(): Any {
        println("This doesn't work yet :C")
        TODO("NOT IMPLEMENTED")
        val primes = sieveOf(10000).convertSieveToPlaces()
        var current = 100
        while (true) {
            if (current % 1000 == 0) println(current)
            val str = current.toString()
            (1..(Math.pow(2.0, str.length.toDouble()).toInt() - 2))
                    .map {
                        val sb = StringBuilder()
                        Integer.toBinaryString(it).format(str.length)
                                .forEachIndexed { index, c -> if (c == '0') sb.append(0) else sb.append(str[index]) }
                        sb.toString()
                    }
                                .forEach { formatted ->
                                    var localCount = 0
                                    (0..9).forEach { if (primes.contains(formatted.replace("0", it.toString()).toInt())) localCount++ }
                                    if (localCount == 7) return formatted
                                }
                        current++
                    }
        }

        private fun countPrimes(num: Long, primes: List<Int>) {
            val str = num.toString()
            var max = 0

        }

        private fun String.format(length: Int) = String.format("%${length}s", this).replace(' ', '0')
    }