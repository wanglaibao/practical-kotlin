package com.laibao.kotlin.coroutine.guide

import kotlinx.coroutines.Dispatchers.Unconfined
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.EmptyCoroutineContext


fun main() = runBlocking{

    /**
     *  launch(){} 函数的第一个参数就是协程上下文,就是指定协程在哪个线程池里面运行，默认是在CommonPool中
     */

    val job1 = launch {
        println(" 执行协程1 ")
        delay(1000)
    }

    /**
     * 这里的 EmptyCoroutineContext
     * 取代了以前老版本中的 CommonPool 切记切记
     */
    val job2 = launch(EmptyCoroutineContext) {
        println(" 执行协程2 ")
        delay(2000)
    }



    val job3 =launch(Unconfined) { //运行在主线程中【main thread】,而且只能运行的主线程中

         println(" 执行协程3 ")
        delay(3000)
    }

    val job4 = launch(coroutineContext){//运行在父协程的上下文中【本示例中是运行在主线程中】

        println(" 执行协程4 ")
        delay(4000)
    }

    val job5 = launch(newFixedThreadPoolContext(10,"新创建的线程-")) {//自定义协程的运行上下文环境


        println(" 执行协程5: ${Thread.currentThread().name} ")
        delay(1000)
    }


    job1.join()
    job2.join()
    job3.join()
    job4.join()
    job5.join()

}