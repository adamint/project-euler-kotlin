package me.circuitrcay.euler.challenges.twentySixToFifty

import me.circuitrcay.euler.Problem
import me.circuitrcay.euler.utils.isPalindrome

class Problem36: Problem<String>() {
    override fun calculate(): Any {
        return (1..999999).filter { it.palindrome210() }.sum()
    }
    private fun Int.palindrome210(): Boolean {
        return this.toString().isPalindrome() && this.toString(2).isPalindrome() &&
                !this.toString(2).startsWith("0")
    }
}