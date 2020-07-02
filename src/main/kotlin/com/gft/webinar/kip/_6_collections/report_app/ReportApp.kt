package com.gft.webinar.kip._6_collections.report_app

fun main() {

	val employeesReport = Reports.employees
	ReportWriter.writeReport(employeesReport)

	/*var transformer: ReportTransformer = GroupingTransformer(listOf("department"), mapOf("id" to "count", "salary" to "sum"))
	ReportWriter.writeReport(transformer.transform(employeesReport), "total-cost-of-department-2.html")

	transformer = GroupingTransformer(listOf("department", "gender"), mapOf("id" to "count", "salary" to "avg"))
	ReportWriter.writeReport(transformer.transform(employeesReport), "employee-diversity-report.html")*/


}
