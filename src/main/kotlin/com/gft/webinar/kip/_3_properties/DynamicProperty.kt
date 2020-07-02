package com.gft.webinar.kip._3_properties

import com.gft.webinar.kip.BADGE_TOP_PERFORMER
import com.gft.webinar.kip.Employee
import com.gft.webinar.kip.employeePrettyPrinter
import com.gft.webinar.kip.util.EmployeesProvider

/**
 * Objectives:
 *
 * 1. "Mutable" properties declared with val keyword
 */
fun main() {
	val topPerformerInTheMaking = EmployeesProvider.employees.find { employee ->
		employee.badges.none { badge -> badge == BADGE_TOP_PERFORMER }
	}!!
	printer.invoke(topPerformerInTheMaking)
	topPerformerInTheMaking.badges.add(BADGE_TOP_PERFORMER)
	printer.invoke(topPerformerInTheMaking)
	employeePrettyPrinter.invoke(topPerformerInTheMaking)
}

val printer: (Employee) -> Unit = { employee ->
	println("Is ${employee.firstName} ${employee.lastName} a top performer: ${employee.isTopPerformer}")
}