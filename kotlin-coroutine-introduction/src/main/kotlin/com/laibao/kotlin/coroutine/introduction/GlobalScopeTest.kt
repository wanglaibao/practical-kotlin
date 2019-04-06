package com.laibao.kotlin.coroutine.introduction

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

fun main() {

    println("主线程开始啦")

    // Globals 是 Coroutines 的一个 builder
    GlobalScope.launch{
        //Delays coroutine for a given time without blocking a thread and resumes it after a specified time.
        delay(4000)
        println("Go! Go! Go! Go! Go!")
    }
    TimeUnit.SECONDS.sleep(5)


    coroTest()
    TimeUnit.SECONDS.sleep(3)
    println("主线程结束啦")
}

fun coroTest() {
    GlobalScope.launch {
        delay(1000L)
        Thread.sleep(2000)
        println("launch ")
    }
    println("----")
}