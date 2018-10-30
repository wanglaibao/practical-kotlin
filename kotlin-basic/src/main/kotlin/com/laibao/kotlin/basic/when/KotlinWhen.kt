package com.laibao.kotlin.basic.`when`

import java.util.*

/**
 * @author laibao wang
 *
 *  Kotlin When
 *      1: Syntax of Kotlin When statement
 *      2: Example – Kotlin When Expression
 *      3: Example – Kotlin When with object of type Any
 *
 */

    /**
     * Kotlin when expression is kind of switch case in Java, but concise in syntax and extended in functionality
     */

    /*
    Syntax of Kotlin When statement

    when (expression) {
        value_1 -> {
            // set of statements
        }
        value_2 -> {
            // set of statements
        }
        value_n -> {
            // set of statements
        }
        else -> {
            // default set of statements
            // when no value matches the evaluated expression's value
        }
    }
     */

fun main(args: Array<String>) {
    testPrintWeekDay(1)
    testPrintWeekDay(2)
    testPrintWeekDay(3)
    testPrintWeekDay(4)
    testPrintWeekDay(5)
    testPrintWeekDay(6)
    testPrintWeekDay(7)
    println()

    testPrintWeekDayWithAnyType(1)
    testPrintWeekDayWithAnyType("TUE")
    testPrintWeekDayWithAnyType(listOf("123"))
    testPrintWeekDayWithAnyType(setOf("456"));
}

fun testPrintWeekDay(number: Int): Unit{
    when (number) {
        1 -> {
            println("Sunday")
        }
        2 -> {
            println("Monday")
        }
        3 -> {
            println("Tuesday")
        }
        4 -> {
            println("Wednesday")
        }
        5 -> {
            println("Thursday")
        }
        6 -> {
            println("Friday")
        }
        7 -> {
            println("Saturday")
        }
        else -> { // Note the block
            println("Invalid value")
        }
    }
    println()
}


fun testPrintWeekDayWithAnyType(element: Any):Unit {
    when (element) {
        1 -> {
            println("Sunday")
        }
        "SUN" -> {
            println("Sunday")
        }
        2 -> {
            println("Monday")
        }
        "MON" -> {
            println("Monday")
        }
        3 -> {
            println("Tuesday")
        }
        "TUE" -> {
            println("Tuesday")
        }
        4 -> {
            println("Wednesday")
        }
        "WED" -> {
            println("Wednesday")
        }
        listOf("123") -> {
            println("123")
        }
        setOf("456") ->{
            println("456")
        }
        else -> {
            println("Invalid value")
        }
    }
}













