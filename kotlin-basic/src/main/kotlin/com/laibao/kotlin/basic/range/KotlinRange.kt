package com.laibao.kotlin.basic.range

/**
 * @author laibao wang
 *
 * Kotlin Ranges could be found in three forms:
 *      1: m..n
 *      2: m until n
 *      3: n downTo m
 */

/**
 *  m..n corresponds to the range[m,n] given m<n. By default, m and n are included in the range
 */

/**
 * m until n corresponds to the range[m,n) given m<n. By default, m is included in the range and n is excluded from the range
 */

/**
 *  n downTo m corresponds to the range[n,m] given m<n. By default, m and n are included in the range
 */
fun main(args: Array<String>) {
    testLoop()
    testUtil()
    testDownTo()
    testCondition()
    println()

    val x = 10
    val y = 9
    if (x in 1..y+1) {
        println("fits in range")
    }
    println()

    val list = listOf("a", "b", "c")
    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices) {
        println("list size is out of valid list indices range too")
    }
    println()

    for (x in 1..5) {
        print(x)
    }
    println()
    for (x in 1..10 step 2) {
        print(x)
    }
    println()
    for (x in 9 downTo 0 step 3) {
        print(x)
    }
}

/**
 * usage of kotlin range m..n in loop statement
 */
fun testLoop() {
    for (element in 1 .. 100) {
        println("the element is $element")
    }
    println()
}

/**
 * usage of kotlin range m until n  in loop statement
 */
fun testUtil() {
    for (element in 1 until 20) {
        println("the element is $element")
    }
    println()
}

/**
 * usage of kotlin range n downTo m  in loop statement
 */
fun testDownTo() {
    for(element in 40 downTo 1){
        println("the element is $element")
    }
    println()
}
/**
 * usage of kotlin range m..n in conditional statement
 *                  and
 * usage of kotlin range m until n  in conditional statement
 *                  and
 * usage of kotlin range n downTo m  in conditional statement
 */
fun testCondition() {
    val number = 100
    if (number in 50 .. 150) {
        println(number.toString() + " is in the range 50..150")
    }else {
        println(number.toString() + " is not in the range 50..150")
    }
    println()

    if(number in 1 until 100){
        println(number.toString() + " is in the range")
    }else {
        println(number.toString() + " is not in the range")
    }

    println()
    if(number in 1 until 101){
        println(number.toString() + " is in the range")
    }else {
        println(number.toString() + " is not in the range")
    }

    println()
    if(number in 200 downTo 50){
        println(number.toString() + " is in the range")
    }else{
        println(number.toString() + " is not in the range")
    }
}