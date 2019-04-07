package com.laibao.kotlin.coroutine.guide

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Structured Concurrency
 */

fun main() {

    runBlocking {
        launch {
            delay(500)
            println(" ${Thread.currentThread().name} Hello from launch")
        }
        println("Hello from runBlocking after launch")
    }

    println("${Thread.currentThread().name} has finished runBlocking")
}