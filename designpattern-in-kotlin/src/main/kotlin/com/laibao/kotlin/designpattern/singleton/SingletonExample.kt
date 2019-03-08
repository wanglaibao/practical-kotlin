package com.laibao.kotlin.designpattern.singleton

import java.util.concurrent.atomic.AtomicLong

fun main() {
    for (i in 1..10000) {
        println(CounterSingleton.increment())
    }
}

/**
 *  Just like regular classes,
 *  objects can extend other classes and implement interfaces
 */
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