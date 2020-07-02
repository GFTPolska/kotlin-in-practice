package com.gft.webinar.kip._4_functions

/*
 * Objectives:
 *
 * 1. What are extension functions and what are they compiled to?
 * 2. What's this in the context of the extension function?
 * 3. How do we call extension functions from Java?
 */
fun String.shuffle(): String {
	return String(this.toMutableList().shuffled().toCharArray())
}

fun main() {
	println("Hello, Kotlin!".shuffle())
}