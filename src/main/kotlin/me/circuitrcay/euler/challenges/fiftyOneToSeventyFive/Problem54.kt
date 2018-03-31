package me.circuitrcay.euler.challenges.fiftyOneToSeventyFive

import me.circuitrcay.euler.Problem
import me.circuitrcay.euler.challenges.fiftyOneToSeventyFive.probUtils.Card
import me.circuitrcay.euler.challenges.fiftyOneToSeventyFive.probUtils.Deck
import me.circuitrcay.euler.challenges.fiftyOneToSeventyFive.probUtils.Suit
import me.circuitrcay.euler.utils.getResource

class Problem54 : Problem<String>() {
    override fun calculate(): Any {
        throw NotImplementedError("not working, but very close!")
        var playerOneWins = 0
        var errors = 0
        val cards = "https://projecteuler.net/project/resources/p054_poker.txt".getResource().split(" ").map { it.toCard() }
        for (i in 0..(cards.size - 10) step 10) {
            if (Deck(*cards.subList(i, i + 5).toTypedArray())
                            .compare(Deck(*cards.subList(i + 5, i + 10).toTypedArray()))) playerOneWins++
        }
        println(errors)
        return playerOneWins
    }

    private fun String.toCard(): Card {
        val valueChar = this[0]
        val suitChar = this[1]
        return Card(when (valueChar) {
            'T' -> 10
            'J' -> 11
            'Q' -> 12
            'K' -> 13
            'A' -> 14
            else -> valueChar.toString().toInt()
        }, when (suitChar) {
            'H' -> Suit.HEART
            'D' -> Suit.DIAMOND
            'S' -> Suit.SPADE
            else -> Suit.CLUB
        })
    }
}