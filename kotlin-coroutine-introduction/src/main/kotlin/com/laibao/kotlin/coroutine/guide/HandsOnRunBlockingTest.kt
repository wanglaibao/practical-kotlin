package com.laibao.kotlin.coroutine.guide

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Let’s finally see some concrete coroutines in action.
 * In a first example, the basics will be shown:
 */


fun main() = runBlocking { //(1)

    /**
     * Coroutines started by launch return a Job immediately,
     * which we can use to cancel the computation or await its completion with (4) join() as we see here.
     * Since calling join() may suspend, we need to wrap this call into another coroutine, which is why we use runBlocking as a wrapper.
     * This concrete coroutine builder (1) “is designed to bridge regular blocking code to suspending functions,
     * and we can use it in main functions and tests” (Quoted API).
     * If we removed the joining of the job, the program would stop before the coroutine can print the result.
     */
    val job = GlobalScope.launch { //(2)
        val result = myMethod("我是金戈我来自中国安徽浙江杭州你呢") //(3)
        println("$result")
    }
    println("The result: ")
    job.join() //(4)
}
// prints "The result: 5"

suspend fun myMethod(str: String) = str.length > 10
