package me.circuitrcay.euler.challenges.twentySixToFifty

import me.circuitrcay.euler.Problem
import java.math.BigInteger

class Problem33 : Problem<String>() {
    override fun calculate(): Any {
        val numerators = mutableListOf<Int>()
        val denominators = mutableListOf<Int>()
        (10..99).forEach { num ->
            (10..99).forEach { denom ->
                if (hasEditedFactor(num, denom)) {
                    numerators.add(num)
                    denominators.add(denom)
                }
            }
        }
        var numProducts = BigInteger.ONE
        var denomProducts = BigInteger.ONE
        numerators.forEach { numProducts = numProducts.times(BigInteger.valueOf(it.toLong())) }
        denominators.forEach { denomProducts = denomProducts.times(BigInteger.valueOf(it.toLong())) }
        val gcm = gcm(numProducts.toInt(), denomProducts.toInt())
        return denomProducts.divide(BigInteger.valueOf(gcm.toLong()))
    }

    private fun hasEditedFactor(numerator: Int, denominator: Int): Boolean {
        if (numerator / denominator.toFloat() > 1f) return false
        var numStr = numerator.toString()
        var denomStr = denominator.toString()
        numStr.forEachIndexed { i, c ->
            if (denomStr.contains(c)) {
                numStr = numStr.replaceFirst(c.toString(), "")
                denomStr = denomStr.replaceFirst(c.toString(), "")
            }
        }
        return numStr != numerator.toString() && numStr.isNotBlank() && denomStr.isNotBlank() && denomStr.toInt() != 0 && numStr.toInt() != 0 &&
                numerator / denominator.toFloat() == numStr.toInt() / denomStr.toFloat() && !numerator.toString().endsWith("0")
    }
    private fun gcm(one: Int, two: Int): Int {
        return if (two == 0) one else gcm(two, one.mod(two))
    }
}