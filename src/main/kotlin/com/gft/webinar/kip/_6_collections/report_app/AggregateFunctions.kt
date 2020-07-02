package com.gft.webinar.kip._6_collections.report_app

import java.math.BigDecimal
import java.math.RoundingMode

object AggregateFunctions {

	val sum: (List<Any>) -> Any = { list ->
		if (list.all { it is Number }) {
			list.map { BigDecimal(it.toString()) }
				.reduce { acc, next -> acc + next }
		} else {
			list.joinToString()
		}
	}

	val concat: (List<Any>) -> Any = {
		it.joinToString()
	}

	val count: (List<Any>) -> Int = {
		it.size
	}

	val uniq: (List<Any>) -> Any = {
		if (it.toSet().size == 1) {
			it.first()
		} else ""
	}

	val avg: (List<Any>) -> Any = { list ->
		if (list.all { it is Number }) {
			list.map { BigDecimal(it.toString()) }
				.reduce { acc, next -> acc + next }
				.divide(BigDecimal(list.size), 2, RoundingMode.HALF_EVEN)
		} else {
			""
		}
	}

}