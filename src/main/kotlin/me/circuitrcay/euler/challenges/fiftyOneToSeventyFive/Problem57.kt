package me.circuitrcay.euler.challenges.fiftyOneToSeventyFive

import me.circuitrcay.euler.Problem
import java.math.BigDecimal
import java.math.BigInteger
import java.math.MathContext
import java.math.RoundingMode

class Problem57 : Problem<String>() {
    override fun calculate(): Any {
        val pairs = mutableListOf<Pair<BigInteger, BigInteger>>()
        var currNum = BigInteger("3")
        var currDenom = BigInteger("2")
        for (i in 2..1001L) {
            val temp = i.toNumPair(currNum, currDenom)
            pairs.add(temp)
            currNum = temp.first
            currDenom = temp.second
        }
        return pairs.filter { it.first.toString().length > it.second.toString().length }.size
    }

    private fun Long.toNumPair(lastNum: BigInteger, lastDenom: BigInteger): Pair<BigInteger, BigInteger> {
        val denom = lastNum + lastDenom
        val num = this.getPrecision().remainder(BigDecimal.ONE) * denom.toBigDecimal() + denom.toBigDecimal()
        return Pair(num.setScale(0, RoundingMode.HALF_UP).toBigInteger(), denom)
    }

    private fun Long.getPrecision(): BigDecimal {
        if (this == 0L) return 2.0.toBigDecimal()
        return 2.0.toBigDecimal().plus(1.0.toBigDecimal().divide((this - 1).getPrecision(), 100, RoundingMode.HALF_UP))
    }
}