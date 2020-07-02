package com.gft.webinar.kip

import java.math.BigInteger
import java.util.function.Predicate

/**
 * https://youtu.be/toGW4diGfVA?t=345
 *
 * Brian Goetz talking about the Java type of the lambda expression
 *
 * What types do we have in java now?
 * 1. primitive types
 * 2. objects (reference types)
 * 3. arrays
 *
 */

const val mavenSalaryThreshold: Double = 1_000_000.0

val mavenPredicate1: (Employee) -> Boolean = { employee ->
    employee.salary >= mavenSalaryThreshold
}

val mavenPredicate2: Predicate<Employee> = Predicate { it.salary >= mavenSalaryThreshold }
val mavenPredicate3: Predicate<Employee> = Predicate { it.salary >= mavenSalaryThreshold }


