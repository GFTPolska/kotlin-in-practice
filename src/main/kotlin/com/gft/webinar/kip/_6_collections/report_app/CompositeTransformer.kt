package com.gft.webinar.kip._6_collections.report_app

class CompositeTransformer(private val transformers: List<ReportTransformer>): ReportTransformer {

	override fun transform(report: Report): Report {
		TODO()
	}

}