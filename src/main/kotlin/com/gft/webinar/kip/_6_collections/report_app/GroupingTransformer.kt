package com.gft.webinar.kip._6_collections.report_app

import com.gft.webinar.kip._6_collections.zip

class GroupingTransformer(private val groupBy: List<String>, private val aggregateFunctions: Map<String, String>): ReportTransformer {

	override fun transform(report: Report): Report {

		// the target list of columns to be in the generated report - firt the groupBy columns and then all whose names are in the aggregateFunctions.keys
		val columns = groupBy + aggregateFunctions.keys

		// making use of the zip function that we implemented in the Zipping.kt
		val grouped = zip(report.columns, report.data) // List<Map<String, Any>> - Map<String, Any> is our single Employee record
			.groupBy { record -> record.entries.filter { it.key in groupBy }.map { it.value } } // Map<GroupColumns, List<Map<String, Any>>>
			.mapValues { entry -> // here we want to reduce a list of employee records to a single record containing aggregated values for all columns/properties in the employee class
				entry.value
					.flatMap { record -> record.entries } // List<Pair<ColumnName, Value>>
					.filter { pairs -> pairs.key in columns } // filtering out columns that should not be in the generated report
					.groupBy( { it.key } ) { it.value }
					.mapValues { getAggregateFunction(it.key).invoke(it.value) }
			} // Map<GroupColumns, Map<String, Any>>


		val data = grouped.values
			.map { it.toSortedMap(compareBy { columns.indexOf(it) }) }
			.map { it.values.toList() }

		return report.copy(
			columns = columns.map {
				if (it in aggregateFunctions.keys) {
					"${aggregateFunctions[it]} ($it)"
				} else it
			},
			data =  data
		)
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