package me.circuitrcay.euler.challenges

import me.circuitrcay.euler.Problem

class Problem1 : Problem<String>() {
    override fun calculate(): Any {

        return (1..999).filter {
            it % 3 == 0 || it % 5 == 0
        }.sum()
    }
}