package com.gft.webinar.kip.util

import com.fasterxml.jackson.module.kotlin.readValue
import com.gft.webinar.kip.Department
import com.gft.webinar.kip.Employee
import com.gft.webinar.kip.util.ObjectMapperProvider.mapper
import java.time.ZoneId
import java.time.ZonedDateTime

object EmployeesProvider {

	val employees: List<Employee> by lazy {
		mapper.readValue<List<Employee>>(EmployeesProvider.javaClass.getResource("/employees.json"))
	}

	val ghostDepartment = Department(-1, "")
	val ghostEmployee = Employee(
		-1,
		"",
		"",
		-1,
		"",
		"",
		"",
		"",
		ZonedDateTime.of(1970, 1, 1, 0, 0, 0, 0, ZoneId.of("GMT")),
		0.0,
		ghostDepartment,
		mutableSetOf()
	)

}