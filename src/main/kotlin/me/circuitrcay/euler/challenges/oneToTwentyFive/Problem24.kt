package me.circuitrcay.euler.challenges.oneToTwentyFive

import me.circuitrcay.euler.Problem
import org.apache.commons.collections4.CollectionUtils

class Problem24: Problem<String>() {
    override fun calculate(): Any {
        return CollectionUtils.permutations(listOf(0, 1, 2, 3,4,5,6,7,8,9)).map { it.joinToString("") }.sorted()[999999]
    }

}