package me.circuitrcay.euler.challenges.twentySixToFifty

import me.circuitrcay.euler.Problem
import me.circuitrcay.euler.utils.convertSieveToPlaces
import me.circuitrcay.euler.utils.sieveOf

class Problem50:Problem<String>() {
    override fun calculate(): Any {
        val convertedSieve = sieveOf(1000000).convertSieveToPlaces()
        var max = Pair(0,0)
        convertedSieve.forEachIndexed { i, int ->
            println(i)
            val localMax = primeLength(int, convertedSieve)
            if (localMax.second > max.second) max = localMax
        }
        return max.first
    }
    private fun primeLength(start:Int, primePlaces:List<Int>): Pair<Int, Int> {
        var sum = start
        var max = 0
        var maxSum = 0
        var currentIndex = primePlaces.indexOf(start) + 1
        while (sum < 1000000 && currentIndex < primePlaces.size) {
            sum += primePlaces[currentIndex]
            if (primePlaces.contains(sum)) {
                max = currentIndex - primePlaces.indexOf(start) + 1
                maxSum = sum
            }
            currentIndex++
        }
        return Pair(maxSum,max)
    }
}