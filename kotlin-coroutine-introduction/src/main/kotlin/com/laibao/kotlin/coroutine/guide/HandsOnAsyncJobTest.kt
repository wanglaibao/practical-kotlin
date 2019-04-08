package com.laibao.kotlin.coroutine.guide

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * 通过异步的方式来创建【启动】协程
 *
 * launch{} : Job  执行某一特定任务 没有返回值 T
 *
 * async{} : Deferred<T>  具有返回值 T
 *
 * 备注:   Deferred<T> : Job; Deferred 是 Job 子类型
 *
 */
fun main() {

    println(Thread.currentThread().name + "主线程开始执行了")

    /**
     * 代码的编写形式是串行的同步的;
     * 但是代码执行的逻辑是并行异步的
     */
    runBlocking {

        val result1:Deferred<String> =  async { excuteTask1() }

        val result2:Deferred<String> =async { excuteTask2() }

        val result3:Deferred<String> = async { excuteTask3() }

        println(result1.await())
        println(result2.await())
        println(result3.await())
    }
    println(Thread.currentThread().name + "主线程执行结束了")
}


suspend fun excuteTask1():String {
    println("开始执行任务1 ")
    delay(2000)
    println("任务1执行完成了 ")
    return "task1"
}

suspend fun excuteTask2():String {
    println("开始执行任务2 ")
    delay(3000)
    println("任务2执行完成了 ")
    return "task2"
}

suspend fun excuteTask3():String {
    println("开始执行任务3 ")
    delay(4000)
    println("任务3执行完成了 ")
    return "task3"
}