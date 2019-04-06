package com.laibao.kotlin.coroutine.introduction

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * delay{}是非阻塞函数
 * Thread.sleep()则是阻塞函数
 * coroutines中使用runBlocking{}作为阻塞函数
 */
fun main() {
    testBlockAndNoBlock()
}

fun testBlockAndNoBlock() {
    //非阻塞，子线程
    GlobalScope.launch {
        delay(1000)
        println("222222222 no-block")
    }
    println("111111111  non block test")

    //会阻塞主线程
    runBlocking {
        delay(3000)
        println("333333333 block")
    }
    println("444444444444 block test")
}


