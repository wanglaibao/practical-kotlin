package com.laibao.kotlin.basic

/**
 * @author laibao wang
 */

fun main(args: Array<String>) {
    var number = 4
    var isEven = isEven(number)
    println("The number is " + (if (isEven) "Even" else "Odd"))
    number = 9
    println("The number is " + (if (isEven) "Even" else "Odd"))
}

fun isEven(n:Int):Boolean = ((n % 2) == 0)