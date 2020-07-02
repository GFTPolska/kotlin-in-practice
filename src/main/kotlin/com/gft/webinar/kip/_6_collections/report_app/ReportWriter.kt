package com.gft.webinar.kip._6_collections.report_app


import kotlinx.html.*
import kotlinx.html.stream.appendHTML
import java.io.File

object ReportWriter {

	fun writeReport(report: Report, path: String = "report.html") {

		File(path).bufferedWriter().use { writer ->
			writer.appendHTML().html {
				body {
					div {
						table {
							this.style = "border: solid thin gray; width: 100%;"
							thead {
								tr {
									this.style = " background: gray;"
									report.columns.forEach {
										td { +it.capitalize() }
									}
								}
							}
							tbody {
								report.data.forEach { record ->
									tr {
										record.forEach { cellValue ->
											td {
												this.style = "border: solid thin gray"
												+"$cellValue"
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

	}

}