package com.gft.webinar.kip._6_collections.report_app

class GroupingTransformerOld(val groupBy: List<String>, val aggregateFunctions: Map<String, String>) : ReportTransformer {

	override fun transform(report: Report): Report {

		val groupByIndices = report.columns.mapIndexedNotNull { index, column ->
			if (column in groupBy) {
				index
			} else null
		}

		val transformedData = report.data
			.groupBy { it.filterIndexed { index, value -> index in groupByIndices } }
			.mapValues { entry ->
				entry.value.flatMap { it.mapIndexed { index, value -> index to value } }
					.groupBy( { it.first } ) { it.second }
					.mapValues { getAggregateFunction(report.columns[it.key]).invoke(it.value) }
					.values.toList()
			}

		val pairs = (groupBy + aggregateFunctions.keys.toList())
			.map { it to report.columns.indexOf(it) }
		val indicies = pairs.map { it.second }
		val columns = report.columns
			.filterIndexed { index, s -> index in indicies }
			.map {
				val aggFun = aggregateFunctions[it]
				if (aggFun != null) {
					"$aggFun(${it.capitalize()})"
				} else it
			}
		val data = transformedData.values.map {
			it.filterIndexed { index, value -> index in indicies }
		}

		return report.copy(columns, data)

	}

	private fun getAggregateFunction(columnName: String): (List<Any>) -> Any {
		return when (aggregateFunctions[columnName] ?: "uniq") {
			"count" -> AggregateFunctions.count
			"sum"   -> AggregateFunctions.sum
			"avg"   -> AggregateFunctions.avg
			else    -> AggregateFunctions.uniq
		}
	}

}