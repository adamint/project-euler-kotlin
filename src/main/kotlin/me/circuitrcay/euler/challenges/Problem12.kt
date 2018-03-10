package me.circuitrcay.euler.challenges

import me.circuitrcay.euler.Problem
import me.circuitrcay.euler.utils.generatePrimeFactorsWithFrequency

class Problem12: Problem<String>() {
    override fun calculate(): Any {
        return factorsOfNumber()
    }

    private fun factorsOfNumber() : Long {
        var numFactors: Int
        var counter = 2L
        while (true) {
            val triangleNumber = counter * (counter + 1) / 2
            val temp = generatePrimeFactorsWithFrequency(triangleNumber)?.values?.map { it + 1 }
            numFactors = temp!!.reduce { acc, i -> acc * i }
            if (numFactors > 500) break
            counter++
        }
        return (counter * (counter + 1) / 2)
    }
}