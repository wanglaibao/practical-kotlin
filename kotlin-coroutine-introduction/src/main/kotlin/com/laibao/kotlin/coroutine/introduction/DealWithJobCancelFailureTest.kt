package com.laibao.kotlin.coroutine.introduction

import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main() = runBlocking{

    val job = launch {
        // 协程里面可以获取 isActive 状态
        (1 .. 1000).forEach{
            if (!isActive) return@launch  //返回协程
            println("打印 $it ")
            TimeUnit.MILLISECONDS.sleep(500)
        }
    }

    delay(2000)
    job.cancel()
    job.join()
}


