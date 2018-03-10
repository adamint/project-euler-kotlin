package me.circuitrcay.euler.challenges

import me.circuitrcay.euler.Problem

class Problem12: Problem<String>() {
    override fun calculate(): Any {
        return factorsOfNumber()
    }

    private fun factorsOfNumber() : Long {
        var numFactors: Int
        var counter = 2L
        while (true) {
            val triangleNumber = counter * (counter + 1) / 2
            val temp = generatePrimeFactorsWithFrequency(triangleNumber)?.values?.map { it + 1 }
            numFactors = temp!!.reduce { acc, i -> acc * i }
            if (numFactors > 500) break
            counter++
        }
        return (counter * (counter + 1) / 2)
    }
}

/**
 * Found this on Github oof https://github.com/tocttou/project-euler-kotlin/blob/master/main/src/utils/FrequencyMap.kt
 */
class FrequencyMap<K, Int>(private val b: MutableMap<K, kotlin.Int>)
    : MutableMap<K, kotlin.Int> by b {
    fun add(key: K, freq: kotlin.Int = 1) {
        b.computeIfPresent(key) { _, b -> b + freq }
        b.putIfAbsent(key, freq)
    }

    fun add(vararg pairs: Pair<K, kotlin.Int>) {
        for (pair in pairs) {
            val (key, freq) = pair
            add(key, freq)
        }
    }

    fun addAll(iter: Iterable<FrequencyMap<K, kotlin.Int>>) {
        for (i in iter) {
            for (j in i.keys) {
                add(j, i.get(j)!!)
            }
        }
    }

    fun removeFreq(key: K, freq: kotlin.Int = 1) {
        if (b.get(key) == null || freq < 1) return
        else if (b.get(key)!! - freq < 1) b.remove(key)
        b.computeIfPresent(key) { _, b -> b - freq }
    }

    override fun hashCode(): kotlin.Int {
        return super.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (!(other is FrequencyMap<*, *>)) return false
        return generateMutableMapFromFrequencyMap(this)
                .equals(generateMutableMapFromFrequencyMap(other))
    }

    fun generateMutableMapFromFrequencyMap(obj: FrequencyMap<*, *>): MutableMap<Any?, Any?> {
        val mMap = mutableMapOf<Any?, Any?>()
        obj.forEach { t, u -> mMap.put(t, u) }
        return mMap
    }
}

fun <K, Int> frequencyMapOf(vararg pairs: Pair<K, kotlin.Int>): FrequencyMap<K, kotlin.Int> {
    val mMap = mutableMapOf<K, kotlin.Int>()
    val freqMap = FrequencyMap<K, kotlin.Int>(mMap)
    for (pair in pairs) {
        freqMap.add(pair)
    }
    return freqMap
}

fun generatePrimeFactorsWithFrequency(
        _n: Number,
        action: (FrequencyMap<Long, Int>) -> Unit = {}
): FrequencyMap<Long, Int>? {
    when (_n) {
        is Long -> {
        }
        is Int -> {
        }
        else -> throw IllegalArgumentException("Only Int and Long are supported.")
    }
    var n = _n.toLong()
    if (n < 2) return null
    val primeFactors = frequencyMapOf<Long, Int>()
    while (n % 2L == 0L) {
        primeFactors.add(2L, 1)
        n /= 2L
    }

    for (i in 3L..Math.sqrt(n.toDouble()).toLong()) {
        while (n % i == 0L) {
            primeFactors.add(i, 1)
            n /= i
        }
    }

    if (n > 2L) primeFactors.add(n, 1)
    action(primeFactors)
    return primeFactors
}