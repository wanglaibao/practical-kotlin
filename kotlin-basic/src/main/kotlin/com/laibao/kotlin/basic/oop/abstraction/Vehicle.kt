package com.laibao.kotlin.basic.oop.abstraction

/**
 * @author laibao wang
 */
interface Vehicle {
    val name:String
    fun run()
    fun stop()
    fun accelerate()
    fun sail() {
        println("the Vehicle can be Sailed")
    }
}