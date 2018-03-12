package me.circuitrcay.euler.challenges.twentySixToFifty

import me.circuitrcay.euler.Problem

class Problem31 : Problem<String>() {
    override fun calculate(): Any {
        var sum = 0
        (0..200).forEach { one ->
            (0..100).forEach { two ->
                (0..40).forEach { five ->
                    (0..20).forEach { ten ->
                        (0..10).forEach { twenty ->
                            (0..4).forEach { fifty ->
                                (0..2).forEach { hundred ->
                                    (0..1).forEach { twoHundred ->
                                        if (one * 1 + two * 2 + five * 5 + ten * 10 + twenty * 20 + fifty * 50
                                                + hundred * 100 + twoHundred * 200 == 200) sum++
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return sum
    }
}
enum class MonetaryValue(val value: Int) {
    ONE_P(1), TWO_P(2), FIVE_P(5), TEN_P(10), TWENTY_P(20), FIFTY_P(50),
    HUNDRED_P(100), TWO_HUNDRED_P(200)
}
