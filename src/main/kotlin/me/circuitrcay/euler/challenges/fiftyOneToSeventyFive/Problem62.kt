package me.circuitrcay.euler.challenges.fiftyOneToSeventyFive

import me.circuitrcay.euler.Problem
import me.circuitrcay.euler.utils.generatePermutations
import java.math.BigInteger


class Problem62 : Problem<String>() {
    override fun calculate(): Any {
        return digitalRoot(BigInteger("64"))
        var curr = BigInteger("3")
        while (true) {
            println("$curr - ${curr.pow(3).calc()}")
            if (curr.pow(3).calc() == 5) return curr
            curr = curr.plus(BigInteger.ONE)
        }
    }

    private fun BigInteger.calc() = toString().generatePermutations().filter { isPerfectCube(it.toBigInteger()) }.count() / 2

    private fun isPerfectCube(n: BigInteger): Boolean {
        when(digitalRoot(n)) {
            1,8,0 -> {
                var curr = 1L
                while (true) {
                    val representation = BigInteger.valueOf(curr).pow(3)
                    if (representation == n) return true
                    else if (representation > n) return false
                    else curr++
                }
            }
            else -> return false
        }
    }
    private fun digitalRoot(n: BigInteger): Int {
        var sum = n.toString().toCharArray().map { it.toString().toInt() }.sum()
        while (sum > 9) {
            sum = sum.toString().toCharArray().map { it.toString().toInt() }.sum()
        }
        return sum
    }
}