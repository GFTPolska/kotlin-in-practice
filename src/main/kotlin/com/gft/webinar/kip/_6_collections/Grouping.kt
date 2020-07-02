package com.gft.webinar.kip._6_collections

import com.gft.webinar.kip.Department
import com.gft.webinar.kip.Employee
import com.gft.webinar.kip.util.EmployeesProvider

/*
 * Objectives:
 *
 * 1. GroupBy vs GroupingBy + the Grouping type
 *
 *  -> Find the highest paid employees per department
 *  -> What is Grouping and how can we benefit from it
 */

fun main() {

	val employees = EmployeesProvider.employees
	println("Highest paid employees per department:")
	highestPaidEmployees(employees).forEach {
		println("\t${it.key.name}: ${it.value?.firstName} ${it.value?.lastName} (${it.value?.gender}) - ${it.value?.salary}")
	}

	// ========== Grouping

	val grouping = employees.groupingBy { employee -> employee.department }

	// what can we do with it?

	// 1. how many employees there are in each department
	println("Employees per department count: ")
	grouping.eachCount().forEach {
		println("\t${it.key.name}: ${it.value}")
	}

	// 2. total salary per department
	println("Total salary per department:")
	grouping
		.fold(0.0) { accumulator, employee ->
			accumulator + employee.salary
		}
		.forEach { department, totalSalary ->
			println("\t${department.name}: $totalSalary")
		}

}

/**
 * This function must return the highest paid employee in each department.
 */
fun highestPaidEmployees(employees: List<Employee>): Map<Department, Employee?> {
	return employees
		.groupBy { employee -> employee.department }
		.mapValues { entry ->
			entry.value.maxBy { employee -> employee.salary }
		}
}