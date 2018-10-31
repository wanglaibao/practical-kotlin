package com.laibao.kotlin.basic.oop.abstraction

/**
 * @author laibao wang
 */
class Aeroplane: Vehicle{

    override val name: String = "air"

    override fun run() {
        println("the Aeroplane is flying")
    }

    override fun stop() {
        println("the Aeroplane is stopping")
    }

    override fun accelerate() {
        println("the Aeroplane is accelerating")
    }
}