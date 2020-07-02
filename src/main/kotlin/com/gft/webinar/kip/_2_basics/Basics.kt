package com.gft.webinar.kip._2_basics

import com.gft.webinar.kip.Employee
import com.gft.webinar.kip.util.EmployeesProvider
import java.io.File
import java.net.URL

/**
 * Objectives:
 *
 * 1. Why/How no-args main function? How does JVM know how to call it?
 * 1. Top level functions, properties and constants.
 * 2. Expressions
 * 3. Nullable vs non-nullable types
 * 4. How to load resource without a class context?
 */

// top level property
val greeting: String = "Hello"

// top level nullable property
val minSalary: Double? = null

// top level lambda
val greetingLambda: (String) -> Unit = { name -> println("Hello, $name") }

// how to load a resource from the Kotlin file?
fun loadResource(name: String): URL {
	// either via object {}, function ({}), or better yet via some top-level property/constant
	return {}.javaClass.getResource(name)
}


fun main() {
	println(File(loadResource("resource.txt").toURI()).readText())
	println("Hello, Kotliners!")
	// Kotlin interoperability with unreleased Java versions.
	val thread = Thread
		.builder()
		.virtual()
		.task(Runnable { println("${Thread.currentThread().name} - Hello from virtual thread in Kotlin!") })
		.build()
	thread.start()
		.also {
			println("${Thread.currentThread().name} - When this line will be executed?")
		}
	thread.join()
}

// class-level constants
class Webinar {
	// const val E = 2.71828 // Const 'val' are only allowed on top level or in objects
	companion object Constants {
		const val PI = 3.1415
	}
}

fun isOdd(number: Int) = if (number%2 == 1) { true } else false

class MyFirstKotlinClass(private val myProp: String)

class MyObject {

	private val prop1: String
	private val prop2: Int
	private var prop3: Employee
		set(value) {
			if (value.isTopPerformer) {
				field = value
			} else {
				throw IllegalArgumentException("We only acceppt top performers!")
			}
		}

	constructor(prop1: String, prop2: Int) {
		this.prop1 = prop1
		this.prop2 = if (prop2 < 0) { 0 } else prop2
	}

	init {
		prop3 = EmployeesProvider.ghostEmployee
	}

	constructor(employee: Employee): this(employee.firstName, employee.salary.toInt()) {
		prop3 = employee
	}

}