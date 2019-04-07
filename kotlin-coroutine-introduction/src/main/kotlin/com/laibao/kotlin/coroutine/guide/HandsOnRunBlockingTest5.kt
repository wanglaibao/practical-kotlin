package com.laibao.kotlin.coroutine.guide

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.math.BigInteger
import java.util.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        val one = async { doSomethingUsefulOne() }

        val two = async { doSomethingUsefulTwo() }

        doSomethingUsefulOne_123()
        println("The answer is ${one.await() + two.await()}")
    }

    println("Completed in $time ms")
}

suspend fun doSomethingUsefulOne(): Int {
    delay(1000L)
    return 13
}

suspend fun doSomethingUsefulTwo(): Int {
    delay(1000L)
    return 29
}

suspend fun doSomethingUsefulOne_123(): BigInteger {
    println("in doSomethingUsefulOne")
    delay(500L)
    return BigInteger(1500, Random()).nextProbablePrime()
}