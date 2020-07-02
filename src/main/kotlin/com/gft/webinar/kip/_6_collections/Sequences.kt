package com.gft.webinar.kip._6_collections

import com.fasterxml.jackson.databind.JsonNode
import com.gft.webinar.kip.Employee
import com.gft.webinar.kip.util.EmployeesProvider
import com.gft.webinar.kip.util.ObjectMapperProvider
import java.util.concurrent.TimeUnit
import kotlin.random.Random
import kotlin.streams.asStream
import kotlin.streams.toList
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

@ExperimentalTime
fun main() {

	val timedValue = measureTimedValue {
		EmployeesProvider.employees
			.asSequence()
			.take(10)
			.toList()
			.parallelStream()
			.map { getEmployeeDetails(it) }
			.toList()
	}
	print("Obtained ${timedValue.value.size} CVs in ${timedValue.duration.inSeconds}s")

}

fun getEmployeeDetails(employee: Employee): CV {
	TimeUnit.MILLISECONDS.sleep(Random.nextLong(100, 1000))
	println("${Thread.currentThread().name} - returning CV for employee ${employee.firstName} ${employee.lastName}")
	return CV(employee, ObjectMapperProvider.mapper.createObjectNode())
}

data class CV(val employee: Employee, val document: JsonNode)