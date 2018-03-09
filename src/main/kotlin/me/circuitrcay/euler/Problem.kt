package me.circuitrcay.euler

import java.io.File


abstract class Problem<E> {
    private val input: String?
    private val parsed: E

    init {
        input = readInput()
        parsed = parse()
    }

    internal fun run() {

        val timer = me.circuitrcay.euler.Timer()

        val locale = "%s%-10s%s%-10s%s"

        timer.start()

        val result = calculate()

        System.out.printf(locale, "Result: ", result, "    ", timer.formatDuration(), "\n")

    }

    private fun readInput(): String? {
        val path = "src/" + this.javaClass.`package`.name.replace(".", "/") + "/input.txt"
        val file = File(path)
        return if (file.exists()) file.toString() else null
    }

    internal abstract fun calculate(): Any

    private fun parse(): E {
        return input as E
    }
}
