package com.gft.webinar.kip.util

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

object ObjectMapperProvider {

	val mapper: ObjectMapper by lazy {
		jacksonObjectMapper()
			.registerModule(JavaTimeModule())
			.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
	}

}