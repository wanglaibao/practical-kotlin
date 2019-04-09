package com.laibao.kotlin.basic.basedatatype

/**
 * @author laibao wang
 */

fun main(args: Array<String>) {
    val a: Int = 10000
    // Prints 'true'
    println(a === a)
    println(a == a)

    val boxedA: Int? = a
    val anotherBoxedA: Int? = a

    //Note that boxing of numbers does not necessarily preserve identity
    // !!!Prints 'false'!!!
    println(boxedA === anotherBoxedA)

    // On the other hand, the boxing of numbers preserve equality
    // Prints 'true'
    println(boxedA == anotherBoxedA)


    val maxDoubleValue = Double.MAX_VALUE
    val minDoubleValue = -Double.MIN_VALUE

    println(maxDoubleValue)
    println(minDoubleValue)
    val maxFloatValue = Float.MAX_VALUE
    val minFloatValue = -Float.MIN_VALUE
    println(maxFloatValue)
    println(minFloatValue)
}
