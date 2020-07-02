package com.gft.webinar.kip

/**
 * So the first thing you learn when you start your journey with Kotlin is that is has properties.
 *
 * So what the heck is a property in Kotlin.
 *
 * Let's have a look at the Kotlin documentation.
 *
 *
 */
class MyFirstClass(val myFirstProperty: String) {
    val mySecondProperty: String = "My first property value"
}

object Factory {
    val count: Int = 1
}

/**
 * Top level methods, fields, constants
 *
 * The ACC_SYNTHETIC attribute is intended by the JVM Bytecode to indicate that an element wasn't actually present in the original source code
 *
 * The JLS (section 13.1) states "Any constructs introduced by the compiler that do not have a corresponding construct in the source code must be marked as synthetic, except for default constructors and the class initialization method.
 */
const val CONSTANT = "MY_CONSTANT"

fun main() {

}