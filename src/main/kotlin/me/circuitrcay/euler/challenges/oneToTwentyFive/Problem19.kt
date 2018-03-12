package me.circuitrcay.euler.challenges.oneToTwentyFive

import me.circuitrcay.euler.Problem
import java.util.*
import java.util.concurrent.TimeUnit
import java.time.temporal.ChronoUnit
import java.time.DayOfWeek
import java.time.LocalDate



class Problem19: Problem<String>() {
    override fun calculate(): Any {
        var sum = 0
        val start = GregorianCalendar.getInstance()
        start.set(1901, 1, 1)
        val end = GregorianCalendar.getInstance()
        end.set(2000, 12, 31)
        while (start.before(end)) {
            if (start.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) sum++
            start.add(Calendar.MONTH, 1)
        }
        return sum
    }

}