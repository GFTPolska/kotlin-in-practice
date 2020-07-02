package com.gft.webinar.kip._6_collections

import com.fasterxml.jackson.module.kotlin.convertValue
import com.gft.webinar.kip.Employee
import com.gft.webinar.kip.util.EmployeesProvider
import com.gft.webinar.kip.util.ObjectMapperProvider
import java.io.File
import kotlin.reflect.full.memberProperties

/**
 * Objectives:
 *
 * 1. To demonstrate expressiveness of the zip function.
 *
 * Interesting facts:
 *
 * 1. Loose end: zip: http://mail.openjdk.java.net/pipermail/lambda-libs-spec-observers/2013-June/002028.html
 *    zip operation was in the initial version of the j.u.s.Stream public API, but Java architects decided not
 *    to include in the the stdlib until value types come to Java.
 *
 */
fun main() {

	val delimiter = ","

	val lines = File(Employee::class.java.getResource("/employees.csv").toURI())
		.readLines()

	val columns = lines
		.first()
		.split(delimiter)
		.toList()

	val values = lines.drop(1)
		.map { it.split(delimiter) }

	val zipped = zip(columns, values)
	println(zipped.take(3))

}

/*
 * [p1]     [v1]
 *  [p2]   [v2]
 *   [p3] [v3]
 *   [p4][v4]
 *   [p5][v5]
 *   [p6][v6]
 *   [p7][v7]
 *   [p8][v8]
 *   [p9][v9]
 */
fun zip(columns: List<String>, values: List<List<Any>>): List<Map<String, Any>> {

	/*val list = mutableListOf<Map<String, Any>>()
	// imperative approach
	for (value in values) {
		val map = mutableMapOf<String, Any>()
		columns.forEachIndexed { index, column ->
			map.put(column, value[index])
		}
		list += map
	}
	return list*/

	// TODO: refactor the above using Kotlin's zip function
	return values.map { record ->
		columns.zip(record).toMap()
	}

}