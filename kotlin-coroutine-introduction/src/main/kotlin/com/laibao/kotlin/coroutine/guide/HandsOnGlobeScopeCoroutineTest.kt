package com.laibao.kotlin.coroutine.guide

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking<Unit> {

    val time = measureTimeMillis {
        val one = GlobalScope.async { doSomethingUsefulThree() }

        val two = GlobalScope.async { doSomethingUsefulFour() }
    }

    println("Completed in $time ms")
}

suspend fun doSomethingUsefulThree(): Int {
    delay(1000L)
    return 13
}

suspend fun doSomethingUsefulFour(): Int {
    delay(1000L)
    return 29
}
