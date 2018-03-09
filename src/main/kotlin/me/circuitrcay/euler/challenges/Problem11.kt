package me.circuitrcay.euler.challenges

import me.circuitrcay.euler.Problem
import me.circuitrcay.euler.utils.Matrix
import java.io.File

class Problem11 : Problem<String>() {
    override fun calculate(): Any {
        val matrix = Matrix(20)

        File("src/main/resources/problem11.txt").forEachLine(Charsets.UTF_8) {
            matrix.add(it.split(" ").map { it.toInt() })
        }

        return matrix.max { a, b, c, d -> a * b * c * d }
    }

}