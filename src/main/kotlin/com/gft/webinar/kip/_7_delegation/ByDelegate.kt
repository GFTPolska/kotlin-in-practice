package com.gft.webinar.kip._7_delegation

import com.gft.webinar.kip.util.EmployeesProvider
import com.gft.webinar.kip.util.ValidatorProvider
import javax.validation.ConstraintViolation
import javax.validation.Validator

/*
 * Objectives
 *
 * 1. How to reuse an implementation of an existing interface and at the same time provide customisations
 *    in selected methods only
 *
 * In this particular case we want to allow single violation in the domain class data
 */

fun main() {

	var violations = ValidatorProvider.validator.validate(EmployeesProvider.employees.first())
	println(violations)
	val validator = RelaxedValidator(ValidatorProvider.validator)
	violations = validator.validate(EmployeesProvider.employees.first())
	println(violations)

}

class RelaxedValidator(private val delegate: Validator): Validator by delegate {

	override fun <T : Any?> validate(obj: T, vararg groups: Class<*>?): MutableSet<ConstraintViolation<T>> {
		val violations = delegate.validate(obj, *groups)
		println(violations)
		return if (violations.size <= 1) {
			mutableSetOf()
		} else {
			violations
		}
	}

}