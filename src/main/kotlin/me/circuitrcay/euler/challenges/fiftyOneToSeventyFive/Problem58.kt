package me.circuitrcay.euler.challenges.fiftyOneToSeventyFive

import me.circuitrcay.euler.Problem
import java.math.BigInteger

class Problem58 : Problem<String>() {
    override fun calculate(): Any {
        val diagonals = getDiagonals(10000000)
        var total = 0f
        var current = 0
        while (true) {
            total = (total + diagonals.subList(current, current + 1).flatten().filter { BigInteger.valueOf(it).isProbablePrime(99) }.toSet().count())
            println(total / ((current + 4) * 2 - 1).toFloat())
            if (total / ((current + 4) * 2 - 1).toFloat() < .1f) return current
            else current++
        }
    }
    private fun getDiagonals(size: Int): List<List<Long>> {
        val master = mutableListOf<List<Long>>()
        (3L..size).forEach { num ->
            val list = mutableListOf<Long>()
            list.add(num * num - 3 * num + 3)
            list.add(num * num - 2 * num + 2)
            list.add(num * num - num + 1)
            list.add(num * num)
            master.add(list.toSet().toList())
        }
        return master
    }
}