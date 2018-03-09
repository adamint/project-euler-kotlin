package me.circuitrcay.euler.challenges

import me.circuitrcay.euler.Problem

class Problem9 : Problem<String>() {
    override fun calculate(): Any {
        for (a in 1..1000) {
            for (b in 1..1000) {
                val c = Math.sqrt((a * a + b * b).toDouble())
                if (a.toDouble() + b.toDouble() + c == 1000.0) return "$a + $b + $c = 1000. Product: ${(a * b * c).toLong()}"
            }
        }
        return "failed"
    }
}