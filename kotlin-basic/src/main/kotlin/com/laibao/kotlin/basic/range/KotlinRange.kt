package com.laibao.kotlin.basic.range

/**
 * @author laibao wang
 * Kotlin Ranges could be found in three forms:
 *      1: m..n
 *      2: m until n
 *      3: n downTo m
 */

/**
 *  m..n corresponds to the range[m,n] given m<n. By default, m and n are included in the range
 */

/**
 *
 */

/**
 *
 */
fun main(args: Array<String>) {
    testLoop()
}

/**
 * Usage of Kotlin range m..n in Loop statement
 */
fun testLoop() {
    for (element in 1 .. 100) {
        println("the element is $element")
    }
}