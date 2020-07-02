package com.gft.webinar.kip._2_basics

class Multiplier(val factor: Double = 1.1) {
	fun multiply(number: Double = 1.0, factor: Double = this.factor): Double = number * factor
}

fun main() {
	val multiplier = Multiplier()
	val result1 = multiplier.multiply(5.0)
	val result2 = multiplier.multiply(factor = 1.15, number = 5.0)
}