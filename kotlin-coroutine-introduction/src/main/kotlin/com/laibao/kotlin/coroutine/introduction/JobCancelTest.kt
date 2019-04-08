package com.laibao.kotlin.coroutine.introduction

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

fun main() {
    testCancel()
}

fun testCancel() {
    println("test cancel")

    val job = GlobalScope.launch {
        for (index in 1..30) {
            println("print $index")
            delay(100)
        }
    }

    println("no waite repeat")

    GlobalScope.launch {
        delay(1000)
        println("cancel ")
        job.cancel()
    }

    TimeUnit.SECONDS.sleep(20)
}