package me.circuitrcay.euler.challenges.twentySixToFifty

import me.circuitrcay.euler.Problem

class Problem40 : Problem<String>() {
    override fun calculate(): Any {
        val sb = StringBuilder()
        var current = 0
        do {
            sb.append(++current)
        } while (sb.length < 1000000)
        return sb[1 - 1].toString().toInt() * sb[10 - 1].toString().toInt() * sb[100 - 1].toString().toInt() * sb[1000 - 1].toString().toInt() *
                sb[10000 - 1].toString().toInt() * sb[100000 - 1].toString().toInt() * sb[1000000 - 1].toString().toInt()
    }
}