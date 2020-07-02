package com.gft.webinar.kip

import com.gft.webinar.kip.util.EmployeesProvider
import java.time.ZonedDateTime
import javax.validation.constraints.Email
import javax.validation.constraints.Size

const val MIN_SALARY = 3000.0

data class Employee(
	val id: Long,
	val firstName: String,
	val lastName: String,
	val age: Int,
	val gender: String,
	// TODO: uncomment when talking about finding employees with invalid e-mail addresses
	@get:Email val email: String,
	val phone: String,
	val address: String,
	val startDate: ZonedDateTime,
	val salary: Double,
	val department: Department,
	// such support was only added in Kotlin 1.3.72: https://youtrack.jetbrains.com/issue/KT-35843
	// TODO: uncomment when talking about finding employees with too few badges
	val badges: MutableSet<@Size(min = 5) String>
) {
    val isTopPerformer: Boolean
		get() {
			return badges.contains("top-performer")
		}
}

fun main() {

	val topPerformer: Employee = EmployeesProvider.employees.find {
		employee -> employee.isTopPerformer
	}!!

	println(topPerformer.isTopPerformer)
	topPerformer.badges.removeIf {
		it == "top-performer"
	}
	println(topPerformer.isTopPerformer)

}