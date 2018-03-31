package me.circuitrcay.euler.challenges.fiftyOneToSeventyFive.probUtils


/**
 * [value] is 1-10 for numbered cards, 11 for J, 12 for Q, and 13 and 14 for K and A respectively
 */
data class Card(val value: Int, val suit: Suit)

enum class Suit { HEART, SPADE, CLUB, DIAMOND }

class Deck(vararg val cards: Card) {
    val royalFlush: Boolean
        get() = cards.filter { it.suit == cards[0].suit }
                .containsAll(listOf(Card(10, cards[0].suit), Card(11, cards[0].suit),
                        Card(12, cards[0].suit), Card(13, cards[0].suit), Card(14, cards[0].suit)))
    val straightFlush: Boolean
        get() {
            val sorted = cards.filter { it.suit == cards[0].suit }.sortedBy { it.value }
            if (sorted.size != 5) return false
            val first = sorted[0].value
            return sorted[1].value == first + 1 && sorted[2].value == first + 2 && sorted[3].value == first + 3
                    && sorted[4].value == first + 4
        }
    val fourOfKind: Boolean
        get() {
            val sorted = sort
            return if (sorted.size > 4) sorted[0] == sorted[3] || sorted[1] == sorted[4] else false
        }
    val fullHouse: Boolean
        get() {
            val sorted = cards.filter { it.suit == cards[0].suit }.sortedBy { it.value }.toMutableList()
            val pair = hasPair(sorted)
            return if (pair == null) false else sorted.filter { it.value != pair && it.suit == sorted[0].suit }.count() == 3
        }
    val flush: Boolean
        get() = cards.filter { it.suit == cards[0].suit }.count() == 5
    val straight: Boolean
        get() {
            val sorted = sort
            val first = sorted[0].value
            return sorted[1].value == first + 1 && sorted[2].value == first + 2 && sorted[3].value == first + 3
                    && sorted[4].value == first + 4
        }
    val threeOfKind: Boolean
        get() {
            val sorted = sort
            for (i in 0..(cards.size - 2)) if (sorted[i] == sorted[2]) return true
            return true
        }
    val twoPairs: Boolean
        get() {
            val sorted = sort
            val first = hasPair(sorted) ?: return false
            val second = hasPair(sorted.filter { it.value != first })
            return second != null
        }
    val pair: Boolean
        get() = hasPair(sort) != null

    fun hasPair(cards: List<Card>): Int? {
        return if (cards.size < 2) null else {
            (0..(cards.size - 2)).forEach { i -> if (cards[i].value == cards[i + 1].value) return cards[i].value }
            return null
        }
    }

    val sort: MutableList<Card>
        get() = cards.sortedBy { it.value }.toMutableList()

    val value: Int
        get() {
            return when {
                royalFlush -> 1000
                straightFlush -> 900
                fourOfKind -> 800
                fullHouse -> 700
                flush -> 600
                straight -> 500
                threeOfKind -> 400
                twoPairs -> 300
                pair -> 200
                else -> sort.last().value
            }
        }

    fun compare(o: Deck): Boolean {
        val firstValue = value
        val secondValue = o.value
        val firstSorted = sort
        val secondSorted = o.sort
        when {
            firstValue > secondValue -> return true
            firstValue < secondValue -> return false
            else -> {
                if (firstValue <= 400 || firstValue == 800) {
                    when (firstValue) {
                        800 -> {
                            val fMax = if (firstSorted[0].value == firstSorted[3].value) firstSorted[0].value else firstSorted[1].value
                            val sMax = if (secondSorted[0].value == secondSorted[3].value) secondSorted[0].value else secondSorted[1].value
                            return when {
                                fMax > sMax -> true
                                fMax < sMax -> false
                                else -> return lastHigher(firstSorted.filter { it.value != fMax }, secondSorted.filter { it.value != sMax })
                            }
                        }
                        100, 200 -> {
                            val fPair = hasPair(firstSorted)!!
                            val sPair = hasPair(secondSorted)!!
                            val fSPair = hasPair(firstSorted.filter { it.value != fPair })
                            val sSPair = hasPair(secondSorted.filter { it.value != sPair })
                            if (fPair != sPair) return fPair > sPair
                            else if (fSPair != null && sSPair != null && fSPair != sSPair) return fSPair > sSPair
                            else return lastHigher(firstSorted.filter { it.value != fPair && it.value != fSPair },
                                    secondSorted.filter { it.value != sPair && it.value != sSPair })
                        }
                        400 -> {
                            val fTrip = when {
                                firstSorted[0].value == firstSorted[2].value -> firstSorted[0].value
                                firstSorted[1].value == firstSorted[3].value -> firstSorted[1].value
                                else -> firstSorted[2].value
                            }
                            val sTrip = when {
                                secondSorted[0].value == secondSorted[2].value -> secondSorted[0].value
                                secondSorted[1].value == secondSorted[3].value -> secondSorted[1].value
                                else -> secondSorted[2].value
                            }
                            if (fTrip != sTrip) return fTrip > sTrip
                            return lastHigher(firstSorted.filter { it.value != fTrip }, secondSorted.filter { it.value != sTrip })
                        }
                        else -> {
                            println("wot")
                            System.exit(1)
                            return false
                        }
                    }
                } else return lastHigher(o)
            }
        }
    }

    fun lastHigher(one: List<Card>, two: List<Card>) = Deck(*one.toTypedArray()).compare(Deck(*two.toTypedArray()))
    fun lastHigher(o: Deck): Boolean {
        val firstSorted = sort
        val secondSorted = o.sort
        var index = 4
        while (index >= 0 && firstSorted[index].value == secondSorted[index].value) index--
        return when {
            firstSorted[index].value > secondSorted[index].value -> true
            else -> false
        }
    }
}