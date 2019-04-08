package com.laibao.kotlin.coroutine.introduction

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main() = runBlocking{

    val job = launch {
        (1 .. 1000).forEach{
            println("打印 $it ")
            //delay(500)    阻塞式的睡眠 是无法取消的   非阻塞是的挂起【suspend关键字修饰的方法】是可以取消的
            TimeUnit.MILLISECONDS.sleep(500)
        }
    }

    delay(2000)
    //取消协程  只能取消挂起无法取消阻塞   挂起【suspend】的时候可以将线程退还到线程池，此时退还的线程还可以重复使用；阻塞时睡眠的时候，线程无法退还到线程池，一直处于阻塞状态
    job.cancel()
    job.join()
}

