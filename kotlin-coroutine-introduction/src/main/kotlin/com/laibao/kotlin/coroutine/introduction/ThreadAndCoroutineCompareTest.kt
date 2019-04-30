package com.laibao.kotlin.coroutine.introduction

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main() {

  /**

    //线程测试开始时间
    val startTime = System.currentTimeMillis()
    val threadList:List<MyThead> = List(100000){ MyThead() }

    threadList.forEach{it.start()}
    threadList.forEach{it.join()}
    //线程测试结束时间
    val endTime = System.currentTimeMillis()
    //线程测试耗时
    val time = endTime - startTime
    println("一共耗时: $time")    //  一共耗时: 40958
   */


  //协程测试开始时间
  val startTime = System.currentTimeMillis()

    runBlocking {
        val coroutinesList:List<Job> = List(100000){
            launch {
                println("${Thread.currentThread().name} 正在运行啦")
                delay(2000)
                println("${Thread.currentThread().name} 运行结束啦")

            }
        }
    }

  //协程测试结束时间
  val endTime = System.currentTimeMillis()


  //协程测试耗时
    val time = endTime - startTime
    println("一共耗时: $time")    //  一共耗时: 2652

}

class MyThead:Thread() {
    override fun run() {
        println("${Thread.currentThread().name} 正在运行啦")
        TimeUnit.SECONDS.sleep(2)
        println("${Thread.currentThread().name} 运行结束啦")
    }
}