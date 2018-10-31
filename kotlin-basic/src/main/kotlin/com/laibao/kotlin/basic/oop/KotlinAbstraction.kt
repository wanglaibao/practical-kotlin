package com.laibao.kotlin.basic.oop

import com.laibao.kotlin.basic.oop.abstraction.Aeroplane
import com.laibao.kotlin.basic.oop.abstraction.American
import com.laibao.kotlin.basic.oop.abstraction.Human
import com.laibao.kotlin.basic.oop.abstraction.Vehicle

/**
 * @author laibao wang
 */

fun main(args: Array<String>) {
    val vehicle: Vehicle = Aeroplane()
    vehicle.accelerate()
    vehicle.run()
    vehicle.sail()
    vehicle.stop()

    val human:Human = American()
    human.drink();
    println(human.category)
    println(human.food)
}
