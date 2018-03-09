package me.circuitrcay.euler.challenges

import me.circuitrcay.euler.Problem

class Problem5 : Problem<String>() {
    override fun calculate(): Any {
        var num = 1
        while (true) {
            var working = true
            for (x in 2..20) {
                if (num / x.toDouble() != (num / x).toDouble()) {
                    num++
                    working = false
                }
            }
            if (working) return num.toString()
        }
    }
}