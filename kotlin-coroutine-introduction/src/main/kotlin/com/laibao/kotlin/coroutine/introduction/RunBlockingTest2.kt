package com.laibao.kotlin.coroutine.introduction

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

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

fun main() {
    testBlock()
}