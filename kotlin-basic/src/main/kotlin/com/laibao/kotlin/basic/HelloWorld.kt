package com.laibao.kotlin.basic

import java.text.SimpleDateFormat
import java.util.*

/**
 * @author laibao wang
 */
fun main(args: Array<String>) {
    println("Hello World !")
    println(SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date()))
    testIfConditions()
    println()
    testIfExpress()
    testWhenExpress()
}

fun testIfConditions() {
    val age = 45
    if (age >= 60) {
        println("老年人")
    }else if (age >= 40 && age < 60) {
        println("中年人")
    }else if (age >= 20 && age < 40) {
        println("青年人")
    } else{
        println("少年人")
    }
}

fun testIfExpress() {
    var age = 20
    //将if表达式赋值给str变量
    var str = if (age > 20) "age 大于 20" else if (age < 20) "age小于20" else "等于20"
    println(str)
}

fun testWhenExpress() {
    val score = 'B'
    when(score){
        'A' -> println("优秀")
        'B' -> println("良好")
        'C' -> println("中等")
        'D' -> println("一般")
        'E' -> println("及格")
        else -> println("不合格")
    }
}