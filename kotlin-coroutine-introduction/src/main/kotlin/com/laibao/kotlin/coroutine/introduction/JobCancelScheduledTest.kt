package com.laibao.kotlin.coroutine.introduction

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout


fun main() = runBlocking{

    val job = launch {


        withTimeout(5000) {
            (1 .. 1000).forEach{
                println(it)
                delay(50)
            }
        }

    }

    job.join()
}