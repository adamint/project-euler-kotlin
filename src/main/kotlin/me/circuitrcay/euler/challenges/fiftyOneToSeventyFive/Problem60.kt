package me.circuitrcay.euler.challenges.fiftyOneToSeventyFive

import me.circuitrcay.euler.Problem
import me.circuitrcay.euler.utils.convertSieveToPlaces
import me.circuitrcay.euler.utils.sieveOf

class Problem60 : Problem<String>() {
    override fun calculate(): Any {
        val primes = sieveOf(50000).convertSieveToPlaces()
        val compare = sieveOf(1000000).convertSieveToPlaces()
        println(primes.last())
        for (a in primes) {
            println(a)
            for (b in primes) {
                if (!checkPrimes(a, b, compare)) continue
                for (c in primes) {
                    if (!checkPrimes(a, c, compare) || !checkPrimes(b, c, compare)) continue
                    for (d in primes) {
                        if (!checkPrimes(a, d, compare) || !checkPrimes(b, d, compare) || !checkPrimes(c, d, compare)) continue
                        for (e in primes) {
                            if (!checkPrimes(a, e, compare) || !checkPrimes(b, e, compare) || !checkPrimes(c, e, compare)
                                    || !checkPrimes(d, e, compare)) continue
                            return a + b + c + d + e

                        }
                    }
                }
            }
        }
        println(primes.size)
        println(primes.filter { it % 2 != 0 && it % 3 != 0 }.size)
        return 0
    }

    private fun checkPrimes(a: Int, b: Int, primes: List<Int>) = primes.contains((a.toString() + b.toString()).toInt()) && primes.contains((b.toString() + a.toString()).toInt())
}