package me.circuitrcay.euler.challenges

import me.circuitrcay.euler.Problem

class Problem15 : Problem<String>() {
    override fun calculate(): Any {
        val result = gridGenerate(20).numberOfNonBackTrackingRoutes()

        return result
    }

}

private class gridGenerate(val size: Int) {
    fun numberOfNonBackTrackingRoutes(): Long = pascal(2 * size, size)

    fun pascal(row: Int, col: Int): Long = if (col == 0) 1 else (row + 1 - col) * pascal(row, col - 1) / col

}