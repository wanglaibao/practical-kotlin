package com.laibao.kotlin.coroutine.introduction

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    val job = launch {
        repeat(1000) {
            println("我挂起了啊")
            delay(500)
        }
    }
    delay(1300)
    println("main 线程等待中")
    job.cancel()
    job.join()
    println("main 线程完成退出了")
}

/**
 * Suspending Functions
 *   Coroutines rely on the suspend keyword, which is a modifier used to mark functions as “suspending”,
 *   i.e., that calls to such functions may suspend at any point.
 *   We can only call these functions from coroutines or other suspending functions.
 */

suspend fun myMethod(p: String): Boolean {
    return false
}