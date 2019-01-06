package com.laibao.kotlin.basic.`when`

/**
 * @author laibao wang
 */

fun main(args: Array<String>) {
    val x = 100
    when (x) {
        1 -> print("x == 1")
        2 -> print("x == 2")
        else -> print("x is neither 1 nor 2")//{
            // Note the block
            //print("x is neither 1 nor 2")
        //}
    }
    println()
    when (x) {
        0, 1 -> print("x == 0 or x == 1")
        else -> print("otherwise")
    }
    println()

    // We can also check a value for being in or !in a range or a collection
    val validNumbers = listOf(1,2,3,4,5,6,7,8,9,10)
    when (x) {
        in 1..10 -> print("x is in the range")
        in validNumbers -> print("x is valid")
        !in 10..20 -> print("x is outside the range")
        else -> print("none of the above")
    }
    println()

    val y = 1000
    when {
        y.isOdd() -> print("x is odd")
        y.isEven() -> print("x is even")
        else -> print("x is funny")
    }

    println(hasPrefix("prefixdfasfdasfd"))

    println(hasPrefixExpress(1231231231))
}


fun Int.isOdd():Boolean = this % 2 == 1

fun Int.isEven():Boolean = this % 2 == 0

fun hasPrefix(x: Any):Boolean {
    when(x) {
        is String -> return x.startsWith("prefix")
        else -> return false
    }
}

fun hasPrefixExpress(x: Any):Boolean = when(x) {
        is String ->  x.startsWith("prefix")
        else -> false
}
