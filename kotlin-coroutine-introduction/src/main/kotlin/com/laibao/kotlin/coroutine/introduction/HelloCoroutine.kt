package com.laibao.kotlin.coroutine.introduction

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main(args: Array<String>) {


    println("主线程开始啦")

    runBlocking  {
        launch {
            //delay(1000)
            for (i in 1 .. 10) {
                delay(1000)
                println("Go! Go! Go! Go! Go!")
            }

        }
    }

    println("主线程结束啦")
}

//fun main() = runBlocking{
//    println("主线程开始啦")
//    launch {
//        delay(10000)
//        for (i in 1 .. 10) {
//            println("Go! Go! Go! Go! Go!")
//        }
//    }
//    println("主线程结束啦")
//
//    TimeUnit.SECONDS.sleep(10)
//}