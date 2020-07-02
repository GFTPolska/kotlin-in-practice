package com.gft.webinar.kip._4_functions

import com.gft.webinar.kip.Employee
import java.math.BigInteger

val predicate1: (Employee) -> Boolean = { employee -> employee.isTopPerformer }
val predicate2: (Employee) -> Boolean = { employee -> employee.isTopPerformer }

val inferredTypeLambda = { it: Employee -> println(it) }

val multipleArgsFunction: (Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int) -> BigInteger = { i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15 ->
	BigInteger.valueOf(i1.toLong())
		.add(BigInteger.valueOf(i2.toLong()))
		.add(BigInteger.valueOf(i3.toLong()))
		.add(BigInteger.valueOf(i4.toLong()))
		.add(BigInteger.valueOf(i5.toLong()))
		.add(BigInteger.valueOf(i6.toLong()))
		.add(BigInteger.valueOf(i7.toLong()))
		.add(BigInteger.valueOf(i8.toLong()))
		.add(BigInteger.valueOf(i9.toLong()))
		.add(BigInteger.valueOf(i10.toLong()))
		.add(BigInteger.valueOf(i11.toLong()))
		.add(BigInteger.valueOf(i12.toLong()))
		.add(BigInteger.valueOf(i13.toLong()))
		.add(BigInteger.valueOf(i14.toLong()))
		.add(BigInteger.valueOf(i15.toLong()))
}