package me.circuitrcay.euler.challenges.oneToTwentyFive

import me.circuitrcay.euler.Problem
import org.jsoup.Jsoup

class Problem22 : Problem<String>() {
    override fun calculate(): Any {
        return Jsoup.connect("https://projecteuler.net/project/resources/p022_names.txt").get().body().text()
                .replace("\"", "").split(",")
                .sorted().mapIndexed { index, s -> s.toLowerCase().map { asInt(it) }.sum() * (index + 1) }.sum()
    }

    fun asInt(char: Char): Int {
        return when (char) {
            'a' -> 1
            'b' -> 2
            'c' -> 3
            'd' -> 4
            'e' -> 5
            'f' -> 6
            'g' -> 7
            'h' -> 8
            'i' -> 9
            'j' -> 10
            'k' -> 11
            'l' -> 12
            'm' -> 13
            'n' -> 14
            'o' -> 15
            'p' -> 16
            'q' -> 17
            'r' -> 18
            's' -> 19
            't' -> 20
            'u' -> 21
            'v' -> 22
            'w' -> 23
            'x' -> 24
            'y' -> 25
            else -> 26
        }
    }
}