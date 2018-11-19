package com.laibao.kotlin.basic.loop

/**
 * @author laibao wang
 * Kotlin for loop is used to:
 *      1: execute a block of statements for each item of a list
 *      2: execute a block of statements for each point in a range
 */

/**
 * using for loop statement, we can loop over any collection that is iterable or any range of elements.
 */

fun main(args: Array<String>) {
    testForList()
    testForRange()
    testWithIndex()
    println()

    val items = listOf("apple", "banana", "kiwifruit")
    for (item in items) {
        println(item)
    }
    println()
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
        println("item index is $index and value is ${items[index]}")
    }
}

/**
 * in the following program, for loop is used to print each item of a list
 */
fun testForList(): Unit {
    var daysOfWeek = listOf("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday")
    for(day in daysOfWeek){
        println(day)
    }
    println()
}

/**
 * in the following example, for loop is used to print elements in a range.
 */
fun testForRange(): Unit {
    for (element in 1 ..10) {
        println(element)
    }

    println("-----------------------------------")

    for (element in 1 until 10) {
        println(element)
    }
    println("-----------------------------------")
}

/**
 *  in the following example, for loop is used to provide a variable to access the index of the element
 */
fun testWithIndex(): Unit {
    var daysOfWeek = listOf("星期天","星期一","星期二","星期三","星期四","星期五","星期六")
    for((index,day) in daysOfWeek.withIndex()){
        println("$index :$day")
    }
    println()
}