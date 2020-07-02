package com.gft.webinar.kip.util

import javax.validation.Validation
import javax.validation.Validator

object ValidatorProvider {

	/**
	 * Provides single bean validation validator for the whole app.
	 */
	val validator: Validator by lazy {
		Validation.buildDefaultValidatorFactory().validator
	}

}