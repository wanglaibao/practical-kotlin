package com.laibao.kotlin.coroutine.guide

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Structured Concurrency
 *
 * Further, we can use this structure to easily delegate the cancellation on a certain coroutine down to its child coroutines
 */

fun main() {
    runBlocking {
        val outerLaunch = launch {
            launch {
                while (true) {
                    delay(300)
                    println("Hello from first inner launch")
                }
            }
            launch {
                while (true) {
                    delay(300)
                    println("Hello from second inner launch")
                }
            }
        }

        println("Hello from runBlocking after outer launch")
        delay(800)
        outerLaunch.cancel()
    }
    println("finished runBlocking")
}

