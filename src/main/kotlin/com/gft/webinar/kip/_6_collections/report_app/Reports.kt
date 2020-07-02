package com.gft.webinar.kip._6_collections.report_app

import com.fasterxml.jackson.module.kotlin.convertValue
import com.gft.webinar.kip.util.EmployeesProvider
import com.gft.webinar.kip.util.ObjectMapperProvider

object Reports {

	val employees: Report by lazy {
		val emps = EmployeesProvider.employees
			.map { ObjectMapperProvider.mapper.convertValue<Map<String, Any>>(it) }
		val columns = emps.first().keys.toList()
		val data = emps.map { it.values.toList() }
		Report(columns, data)
	}

}