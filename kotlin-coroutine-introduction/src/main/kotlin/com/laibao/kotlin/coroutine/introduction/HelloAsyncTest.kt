package com.laibao.kotlin.coroutine.introduction

import kotlinx.coroutines.*

fun main() = runBlocking {

    val job = launch {
        repeat(1000) {
            println("我挂起了啊")
            delay(500)
        }
    }

    val job2:Deferred<String> = async {
        println("")
        println("")
        delay(500)
        return@async "async"
    }

    println("job2 的输出如右边: ${job2.await()}")
    delay(1300)
    println("main 线程等待中")
    job.cancel()
    job.join()
    println("main 线程完成退出了")
}