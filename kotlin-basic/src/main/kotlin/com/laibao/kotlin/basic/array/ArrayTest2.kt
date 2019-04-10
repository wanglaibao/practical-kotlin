package com.laibao.kotlin.basic.array

fun main() {

    val arr:Array<Int> = arrayOf(1,2,3,4,5,6,7,8,9,10)
    arr.forEach { println(it) }
    println("-----------------------------------")
    arr[0] = 1000
    arr.set(1,2000)
    arr[9] = 90
    arr.set(8,800)
    println("------------------------------------")
    arr.forEach { println(it) }
}