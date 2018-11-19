package com.laibao.kotlin.basic.loop

/**
 * @author laibao wang
 *
 */


/**
 *  kotlin while statement is used to repeat a task,
 *  checking the condition priorly for each iteration before executing the iterative block
 */

/**
 * kotlin do-while loop is the same as while loop,
 * except that the condition is not checked for the first time before executing the iterative block.
 * therefore it is guaranteed that the iterative block is executed at least once
 */

fun main(args: Array<String>) {
    testWhile()
    testWhileWithBreak()
    testDoWhile()

    val items = listOf("apple", "banana", "kiwifruit")
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }
}

fun testWhile():Unit {
    var number = 0
    while (number < 10) {
        println("hello, the number is $number")
        number += 1
    }
    println()
}

fun testWhileWithBreak():Unit {
    var number = 100
    while (true) {
        number += 1
        println("hi, the number is $number")
        if (number > 120) {
            break
        }
    }
    println()
}

fun testDoWhile(): Unit {
    var number = 1000
    do {
        println("heheh, the number is $number")
        number += 1
    }while (number < 1020)
}