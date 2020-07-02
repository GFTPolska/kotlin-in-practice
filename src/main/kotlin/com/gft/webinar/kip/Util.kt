package com.gft.webinar.kip

import com.gft.webinar.kip.util.ObjectMapperProvider

val employeePrinter: (Employee) -> Unit = { employee ->
	println(employee)
}

val employeePrettyPrinter: (Employee) -> Unit = { employee ->
	println(ObjectMapperProvider.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee))
}