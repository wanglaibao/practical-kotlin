package com.laibao.kotlin.coroutine.guide

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun fetchUserString(userId: String): String {
    // request user from network
    // return user String
    return ""
}

suspend fun fetchUserData(userId: String): String {
    // return user String
    return ""
}


fun main() = runBlocking {

    println("主线程开始啦")
    val job = launch {
        println("协程执行之前: ${Thread.currentThread().name}")
        delay(20000)
        println("协程执行之后: ${Thread.currentThread().name}")
    }
    println("主线程结束啦")
    job.join()
}