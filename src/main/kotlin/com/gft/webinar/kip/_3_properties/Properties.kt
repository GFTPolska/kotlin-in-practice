package com.gft.webinar.kip._3_properties

abstract class Engine(open val capacity: Int, open val power: Int)
// TODO: consider changing Engine from abstract class into an interface - the same with Vehicle
class RacingEngine(override val capacity: Int, override val power: Int): Engine(capacity, power)

interface Vehicle{
	val engine: Engine
}
class RacingVehicle(override val engine: RacingEngine): Vehicle

fun main() {
	val vehicle = RacingVehicle(RacingEngine(6000, 600))
	println(vehicle)
}
