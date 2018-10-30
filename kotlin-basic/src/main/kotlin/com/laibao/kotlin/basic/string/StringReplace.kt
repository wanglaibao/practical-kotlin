package com.laibao.kotlin.basic.string

/**
 * @author laibao wang
 */

fun main(args: Array<String>) {
    testReplace()
    println()
    testReplaceWithIgnoreCase()
}

/*
        Syntax of String replace()
        Syntax of String.replace method is

        String.replace(oldValue: String, newValue: String, ignoreCase: Boolean = false): String
 */


fun testReplace() {
    val str = "Kotlin Tutorial - Replace String - Programs"
    val oldValue = "Programs"
    val newValue = "Examples"
    val result = str.replace(oldValue, newValue)
    println(result)
}


fun testReplaceWithIgnoreCase() {
    val str = "Kotlin Tutorial - Replace String - Programs"

    val oldValue = "PROGRAMS"

    val newValue = "Examples"

    val result = str.replace(oldValue, newValue, ignoreCase = true)

    println(result)
}