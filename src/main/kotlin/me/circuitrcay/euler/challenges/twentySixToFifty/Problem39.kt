package me.circuitrcay.euler.challenges.twentySixToFifty

import me.circuitrcay.euler.Problem

class Problem39 : Problem<String>() {
    override fun calculate(): Any {
        var max = 0
        var pMax = 0
        (2..1000).forEach { p ->
            println(p)
            val cSolutions = mutableListOf<Double>()
            (1..999).forEach { a ->
                (1..999).forEach { b ->
                    val c = Math.sqrt(Math.pow(a.toDouble(), 2.0) + Math.pow(b.toDouble(), 2.0))
                    if (c + a + b == p.toDouble() && !cSolutions.contains(c)) cSolutions.add(c)
                }
            }
            if (cSolutions.size > max) {
                max = cSolutions.size
                pMax = p
            }
        }
        return "$pMax ($max solutions)"
    }
}