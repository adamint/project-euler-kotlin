package me.circuitrcay.euler.challenges

import me.circuitrcay.euler.Problem
import java.util.ArrayList




class Problem14 : Problem<String>() {
    override fun calculate(): Any {
        val limit = 1000000 // Limit is one million
        var size = 0
        var max = 1
        var j = 0
        for (i in 2 until limit) {
            size = getChainSize(i)
            if (size > max) {
                max = size
                j = i
            }
        }
        return j
    }

    private fun getChainSize(n: Int): Int {

        var num = n.toLong()
        val list = ArrayList<Long>()
        var size = 0
        while (num != 1L) {
            list.add(num)
            num = if (num % 2 == 0L) {
                num / 2
            } else {
                3 * num + 1
            }
        }
        size = list.size
        return size
    }
}



