package me.circuitrcay.euler.challenges.fiftyOneToSeventyFive

import me.circuitrcay.euler.Problem
import me.circuitrcay.euler.utils.convertSieveToPlaces
import me.circuitrcay.euler.utils.sieveOf

class Problem60 : Problem<String>() {
    override fun calculate(): Any {
        val primes = sieveOf(10000).convertSieveToPlaces()
        return getPrimes(792,primes)
        val found = mutableListOf<Int>()
        for (a in primes) {
            println(a)
            for (b in primes) {
                if (!checkPrimes(a, b)) continue
                for (c in primes) {
                    if (!checkPrimes(a, c) || !checkPrimes(b, c)) continue
                    for (d in primes) {
                        if (!checkPrimes(a, d) || !checkPrimes(b, d) || !checkPrimes(c, d)) continue
                        found += a + b + c + d
                        continue
                        /*  for (e in primes) {
                    if (!checkPrimes(a, e) || !checkPrimes(b, e) || !checkPrimes(c, e)
                            || !checkPrimes(d, e)) continue
                    return a + b + c + d + e
                }*/
                    }
                }
            }
        }
        return found
        println(primes.size)
        println(primes.filter { it % 2 != 0 && it % 3 != 0 }.size)
        return 0
    }

    private fun checkPrimes(a: Int, b: Int) = ((a.toString() + b.toString()).toBigInteger().isProbablePrime(90))
            && ((b.toString() + a.toString()).toBigInteger().isProbablePrime(90))

    private fun getPrimes(num: Int, primes: List<Int>): List<Int> {
        val matches = mutableListOf<Int>()
        primes.forEach { if (it > num) return matches else if (num % it == 0) matches.add(it) }
        return matches
    }
}