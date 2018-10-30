package com.laibao.kotlin.basic.string

/**
 * @author laibao wang
 */

fun main(args: Array<String>) {
    testEquals()
    testCompareTo()
}

fun testEquals(){
    val a: String = "kotlin is easy"
    val b: String = "kotlin is" + " easy"
    if(a == b){
        println("Strings '$a' and '$b' are equal.")
    } else {
        println("Strings '$a' and '$b' are not equal.")
    }

    println()

    val c = "Kotlin runs on JVM"
    if(a == c){
        println("Strings '$a' and '$b' are equal.")
    } else {
        println("Strings '$a' and '$b' are not equal.")
    }
}


/*
    Using compareTo() extension function
    Kotlin provides compareTo() extension function to String
    Syntax of compareTo() function is given below

    fun String.compareTo(
            other: String,
            ignoreCase: Boolean = false
    ): Int
*/


fun testCompareTo() {
    val a: String = "apple"
    val b: String = "apple"
    val result0 = a.compareTo(b)

    if(result0 == 0){
        println("Strings '$a' and '$b' are equal.")
    } else if(result0 < 0){
        println("'$a' is less than '$b' lexically.")
    } else{
        println("'$a' is less than '$b' lexically.")
    }

    val c = "banana"
    val result1 = a.compareTo(c)
    if(result1 == 0){
        println("Strings '$a' and '$b' are equal.")
    } else if(result1 < 0){
        println("'$a' is less than '$b' lexically.")
    } else{
        println("'$a' is less than '$b' lexically.")
    }

    // passing ignoreCase to compareTo
    val d = "appLE"
    val e = "aPple"
    println("\nIgnoring Case...")
    val result2 = d.compareTo(e, true) // ignoreCase = true
    if(result2 == 0){
        println("Strings '$a' and '$b' are equal.")
    } else if(result2 < 0){
        println("'$a' is less than '$b' lexically.")
    } else{
        println("'$a' is less than '$b' lexically.")
    }
}