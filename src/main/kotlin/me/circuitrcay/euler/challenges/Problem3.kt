package me.circuitrcay.euler.challenges

import me.circuitrcay.euler.Problem

class Problem3: Problem<String>() {
    override fun calculate(): Any {
        var num = 600851475143L
        var x = 2L
        while (x < num / x) {
            while (num % x == 0L) num /= x
            x++
        }
        return num
    }
}