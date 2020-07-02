package com.gft.webinar.kip._5_annotations

import com.gft.webinar.kip.util.EmployeesProvider
import com.gft.webinar.kip.util.ValidatorProvider
import java.lang.IllegalStateException

/**
 * Objectives:
 *
 * 1. What to pay attention to when decorating Kotlin properties with annotations?
 */
fun main() {

	// TODO #1 - find employees with invalid e-mail addresses (make sure the @Email bean validation annotation is present on the email property of Employee class)

	// TODO #2 - find employees with too few badges
	val invalid = EmployeesProvider.employees
		.filter { ValidatorProvider.validator.validate(it).isNotEmpty() }
	println("Invalid employees count: ${invalid.size}")

}