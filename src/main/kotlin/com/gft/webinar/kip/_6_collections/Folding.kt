package com.gft.webinar.kip._6_collections

import com.gft.webinar.kip.BADGE_TOP_PERFORMER
import com.gft.webinar.kip.Employee
import com.gft.webinar.kip.util.EmployeesProvider
import java.time.Duration
import java.time.ZonedDateTime

fun main() {
	val raiseCalculator = CompositeRaiseCalculator(listOf(SeniorityRaiseCalculator(), BadgeRaiseCalculator()))
	val employeesWithRaise = EmployeesProvider.employees
		.map { employee ->
			raiseCalculator.calculateRaise(employee)
		}
		.filter { pair -> pair.second > 0.0 }

	val highestRaise = employeesWithRaise.maxBy { it.second }!!
	println("Congratulations, ${highestRaise.first.firstName} ${highestRaise.first.lastName}... But we can't afford your ${highestRaise.second} raise, and so you're... fired!!!")
}

interface RaiseCalculator {
	fun calculateRaise(employee: Employee): Pair<Employee, Double>
}

class SeniorityRaiseCalculator: RaiseCalculator {

	override fun calculateRaise(employee: Employee): Pair<Employee, Double> {
		val seniority =
			Duration.between(employee.startDate, ZonedDateTime.now()).toDays()
		val factor: Double = when (seniority) {
			in 1..365 -> 0.0
			in 365*1+1..365*2 -> 0.01
			in 365*2+1..365*3 -> 0.02
			in 365*3+1..365*4 -> 0.03
			in 365*4+1..365*5 -> 0.04
			else -> 0.05
		}
		return employee to employee.salary * factor
	}

}

class BadgeRaiseCalculator: RaiseCalculator {

	override fun calculateRaise(employee: Employee): Pair<Employee, Double> {
		val badges = employee.badges
		val factor = when {
			badges.size == 7 -> 0.05
			badges.contains(BADGE_TOP_PERFORMER) -> 0.03
			else -> 0.0
		}
		return employee to employee.salary * factor
	}

}

class CompositeRaiseCalculator(private val calculators: List<RaiseCalculator>): RaiseCalculator {

	override fun calculateRaise(employee: Employee): Pair<Employee, Double> {
		/*// imperative implementation
		var totalRaise: Double = 0.0
		calculators.forEach { calculator ->
			totalRaise += calculator.calculateRaise(employee).second
		}
		return employee to totalRaise*/

		// TODO: change to more functional implementation
		return calculators.fold(Pair(employee, 0.0)) { acc, raiseCalculator ->
			val raise = raiseCalculator.calculateRaise(employee).second
			acc.copy(second = acc.second + raise)
		}

	}

}

