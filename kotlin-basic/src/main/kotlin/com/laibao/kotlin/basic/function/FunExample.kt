package com.laibao.kotlin.basic.function

/**
 * @author laibao wang
 */

fun main(args: Array<String>) {
    val sum = sum(10,10)
    println("the sum is $sum")
    println()
    printSumOne(100,200)
    println()
    printSumTwo(1000,2000)
    println()
    printSumThree(10000,20000)
}

fun sum(a:Int,b:Int):Int {
    return a + b
}

fun printSumOne(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}

fun printSumTwo(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}

fun printSumThree(a: Int, b: Int) {
    println("sum of $a and $b is ${a + b}")
}