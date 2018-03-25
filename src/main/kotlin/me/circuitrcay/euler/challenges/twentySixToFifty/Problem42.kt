package me.circuitrcay.euler.challenges.twentySixToFifty

import me.circuitrcay.euler.Problem
import me.circuitrcay.euler.utils.alphabeticalPosition
import me.circuitrcay.euler.utils.triangleNumbersOf
import org.jsoup.Jsoup

class Problem42: Problem<String>() {
    override fun calculate(): Any {
        val triangleNumbers = triangleNumbersOf(100)
        return Jsoup.connect("https://projecteuler.net/project/resources/p042_words.txt").get().body().text()
                .replace("\"", "").split(",").filter { triangleNumbers.contains(it.toLowerCase().value()) }.count()
    }
    private fun String.value() = map { it.alphabeticalPosition() }.sum()
}