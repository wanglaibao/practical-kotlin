package com.laibao.kotlin.coroutine.introduction

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main() {
    testBlock()
    testWaitJob()
}

/**
 * 实际上，runBlocking{} 不是直接用在协程中的，
 * 常常用于桥接一些挂起函数操作，
 * 用于顶底函数或者Junit Test中,例如如下代码：
 */

fun testBlock() = runBlocking {
    val job= launch {
        delay(1000)
        println("in run block")
    }
    job.join()
}


/**
 * 上面提到了可以通过 delay() 来等待一个函数执行，并且是非阻塞的
 * coroutines 中也提供了另一种等待机制,简单的例子如下
 */

fun testWaitJob() {
    val job = GlobalScope.launch {
        delay(2000)
        println("waite")
    }

    println("main doing")

    GlobalScope.launch {
        job.join()
        println("really excute")
    }

    TimeUnit.SECONDS.sleep(5)
    println("一切结束了啊")
}
