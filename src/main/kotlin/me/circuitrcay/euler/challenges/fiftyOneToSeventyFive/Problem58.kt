package me.circuitrcay.euler.challenges.fiftyOneToSeventyFive

import me.circuitrcay.euler.Problem
import java.math.BigInteger

class Problem58 : Problem<String>() {
    override fun calculate(): Any {
        val diagonals = mutableListOf<Long>()
        var current = 0
        while (true) {
            val num = current + 3
            diagonals.add(listOf(num * num - 3 * num + 3, num * num - 2 * num + 2,num * num - num + 1,num*num).filter { BigInteger.valueOf(it.toLong()).isProbablePrime(99) }.count().toLong())
            println(diagonals.sum() / (4 * (current / 2 + 1) + 1).toFloat())
            if (diagonals.sum() / (4 * (current / 2 + 1) + 1).toFloat() < 0.1f) return current + 3
            current+=2
        }
    }
}