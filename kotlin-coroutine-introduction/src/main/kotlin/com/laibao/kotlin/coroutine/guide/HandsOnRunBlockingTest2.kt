package com.laibao.kotlin.coroutine.guide

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Structured Concurrency
 *
 * This output tells us that runBlocking does not complete before its child coroutine started by launch finishes its work
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