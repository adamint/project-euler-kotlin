package me.circuitrcay.euler.challenges.twentySixToFifty

import me.circuitrcay.euler.Problem

class Problem43 : Problem<String>() {
    override fun calculate(): Any {
        val nums = mutableListOf<Long>()
        // d1 can be any number
        // d4 can be 0, 2, 4, 6, or 8
        // d6 can be either 0 or 5
        // it must be a pandigital number, so continue if num is not unique inside the loop
        // these insights bring solve time down from 15 minutes (brute force) to 300 milliseconds

        for (one in 0..9 step 1) {
            for (two in 0..9 step 1) {
                if (two.isNotUnique(one)) continue
                for (three in 0..9 step 1) {
                    if (three.isNotUnique(one, two)) continue
                    for (four in 0..8 step 2) {
                        if (four.isNotUnique(one, two, three)) continue
                        if (toInt(two, three, four) % 2 == 0) {
                            for (five in 0..9 step 1) {
                                if (five.isNotUnique(one, two, three, four)) continue
                                if (toInt(three, four, five) % 3 == 0) {
                                    for (six in 0..5 step 5) {
                                        if (six.isNotUnique(one, two, three, four, five)) continue
                                        if (toInt(four, five, six) % 5 == 0) {
                                            for (seven in 0..9 step 1) {
                                                if (seven.isNotUnique(one, two, three, four, five, six)) continue
                                                if (toInt(five, six, seven) % 7 == 0) {
                                                    for (eight in 0..9 step 1) {
                                                        if (eight.isNotUnique(one, two, three, four, five, six, seven)) continue
                                                        if (toInt(six, seven, eight) % 11 == 0) {
                                                            for (nine in 0..9 step 1) {
                                                                if (nine.isNotUnique(one, two, three, four, five, six, seven, eight)) continue
                                                                if (toInt(seven, eight, nine) % 13 == 0) {
                                                                    for (ten in 0..9 step 1) {
                                                                        if (ten.isNotUnique(one, two, three, four, five, six, seven, eight, nine)) continue
                                                                        if (toInt(eight, nine, ten) % 17 == 0) {
                                                                            nums.add(toLong(one, two, three, four, five, six, seven, eight, nine, ten))
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return nums.sum()
    }

    private fun Int.isNotUnique(vararg others: Int) = others.contains(this)
    private fun toInt(vararg ints: Int) = ints.joinToString("") { it.toString() }.toInt()
    private fun toLong(vararg longs: Int) = longs.joinToString("") { it.toString() }.toLong()
}