package me.circuitrcay.euler.challenges.fiftyOneToSeventyFive

import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import me.circuitrcay.euler.Problem

class Problem61 : Problem<String>() {
    override fun calculate(): Any {
        val triangle = (1..140).map { (it * (it + 1)) / 2 }.filter { it.toString().length == 4 }
        val square = (1..99).map { it * it }.filter { it.toString().length == 4 }
        val pentagon = (1..81).map { (it * (3 * it - 1)) / 2 }.filter { it.toString().length == 4 }
        val hexagon = (1..70).map { it * (2 * it - 1) }.filter { it.toString().length == 4 }
        val heptagon = (1..63).map { (it * (5 * it - 3)) / 2 }.filter { it.toString().length == 4 }
        val octagon = (1..58).map { it * (3 * it - 2) }.filter { it.toString().length == 4 }

        runBlocking {
            triangle.forEach {
                launch { it.find(listOf(it), square, pentagon, hexagon, heptagon, octagon) }.join()
            }
        }
        return "look above :)"
    }

    private fun Int.lastTwo() = toString().substring(2)
    private fun Int.find(progression: List<Int>, vararg lists: List<Int>) {
        if (lists.size == 1) {
            lists[0].filter { it.toString().startsWith(this.lastTwo()) && progression[0].toString().startsWith(it.lastTwo()) }.getOrNull(0)
                    ?.let { println("${progression + it} - Sum: ${(progression + it).sum()}") }
        }
        lists.forEach { list ->
            list.filter { it.toString().startsWith(this.lastTwo()) }.forEach {
                it.find(progression + it, *lists.filter { it != list }.toTypedArray())
            }
        }
    }
}