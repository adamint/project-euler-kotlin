package me.circuitrcay.euler

import java.util.*

fun main(args: Array<String>) {
    val helperClasses = 5
    println("This is Project Euler: Kotlin containing solved Euler problems by CodeFromCirc & adamint")
    println("-----------------\n")
    println("Enter the number of the problem you'd like to solve")
    while (true) {
        val scanner = Scanner(System.`in`)
        val command = scanner.nextLine()

        val problemArray = ProblemLoader.getClasses("me.circuitrcay.euler")
        var found = false
        problemArray.forEach { problem ->
            if (problem.name.contains(command.toRegex())) {
                try {
                    val challenge = problem.newInstance() as Problem<*>
                    println("Solving Euler Problem $command..")
                    challenge.run()
                }
                catch(e: Exception) {
                    if (e !is IllegalAccessException && e!is InstantiationException) e.printStackTrace()
                }
                found = true
            }
        }
        if (!found) println("We haven't solved that problem yet! Total solved: 1 to ${problemArray.size - helperClasses}")
        println("\nEnter the number of the problem you'd like to solve")
    }
}
