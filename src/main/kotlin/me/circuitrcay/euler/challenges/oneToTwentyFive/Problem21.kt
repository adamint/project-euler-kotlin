package me.circuitrcay.euler.challenges.oneToTwentyFive

import me.circuitrcay.euler.Problem

class Problem21 : Problem<String>() {
    override fun calculate(): Any {
        var sum = 0
        (1..10000).forEach { num ->
            if (divisorsSum(divisorsSum(num)) == num && divisorsSum(num) != num) {
                sum += num
                println(num)
            }
        }
        return sum
    }

    private fun divisorsSum(i: Int): Int {
        var sum = 0
        for (x in (1..(i - 1)) step 1) if (i % x == 0) sum += x
        return sum
    }
}