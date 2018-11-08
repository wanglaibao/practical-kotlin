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