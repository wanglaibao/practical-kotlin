package com.laibao.kotlin.designpattern.singleton

import java.util.concurrent.atomic.AtomicLong

/**
 * The singleton pattern ensures that only one object of a particular class is ever created.
 * All further references to objects of the singleton class refer to the same underlying instance.
 *
 */

/**
 *  Just like regular classes,
 *  objects can extend other classes and implement interfaces
 */

fun main() {
    println("Start")
    PrinterDriver.print()
    PrinterDriver.print()
    PrinterDriver.print()
    PrinterDriver.print()
    println()
    for (i in 1..10) {
        println(CounterSingleton.increment())
    }
}

object PrinterDriver {
    init {
        println("Initializing with object: $this")
    }

    fun print() = println("Printing with object: $this")
}


object CounterSingleton {

    init {
        println("initialization logic for\n" +
                "Singleton, such as loading data from the database or over the network for\n" +
                "the first time")
    }

    // More code goes here
    private val counter = AtomicLong(0)

    fun increment() = counter.incrementAndGet()
}