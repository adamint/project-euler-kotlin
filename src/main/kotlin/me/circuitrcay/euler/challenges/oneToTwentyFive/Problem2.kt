package me.circuitrcay.euler.challenges.oneToTwentyFive

import me.circuitrcay.euler.Problem

class Problem2 : Problem<String>() {
    override fun calculate(): Any {
        var sum = 0

        var num1 = 1; var num2 = 2

        while (num2 < 4000000) {
            if(num2 % 2 == 0) sum += num2

            val temp = num2

            num2 = num1 + num2
            num1 = temp

        }

        return sum
    }
}