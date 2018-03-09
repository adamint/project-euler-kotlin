package me.circuitrcay.euler

import java.util.*

fun main(args: Array<String>) {
    println("This is Project Euler.")
    val scanner = Scanner(System.`in`)
    val command = scanner.nextLine()

    val problemArray = ProblemLoader.getClasses("me.circuitrcay.euler")
    problemArray.forEach { problem ->
       if(problem.name.contains(command.toRegex())) {
         val challenge = problem.newInstance() as Problem<*>
         challenge.run()
       }
    }
}
