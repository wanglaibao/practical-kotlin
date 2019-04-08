package com.laibao.kotlin.coroutine.introduction

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking{

    val job = launch {
        (1 .. 1000).forEach{
            println(it)
            delay(500)
        }
    }
    delay(5000)
    job.cancel()
    job.join()
}