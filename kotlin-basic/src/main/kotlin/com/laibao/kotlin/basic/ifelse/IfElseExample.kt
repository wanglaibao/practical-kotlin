package com.laibao.kotlin.basic.ifelse

/**
 * @author laibao wang
 */

fun main(args: Array<String>) {
    println(maxOf(100,200))
    println()
    println(minOf(10000,20000))

    parseInt("AAAAAAAAAAAAAA")

    println("字符串转化成整数: ${parseInt("safdasfasfd")}")

    printlnMultiplyResult("1000", "2000")

    printlnMultiplyResult("safasf", "fasdfsafd")

    printlnMultiplyResultTwo("10", "200")

    printlnMultiplyResultTwo("sad1000", "sadf2000")


    // Traditional usage
    var max = 0
    val a = 10
    val b = 20
    if (a < b) max = b  // 这里的 if 是赋值语句而不是表达式语句
    println("max == $max")

    // With else
    var min: Int
    if (a > b) {
        min = b
    } else {
        min = a
    }
    println("min == $min")

    // As expression
    min = if (a > b) a else b
    println("the min value is $min")
}

fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    }else {
        return b
    }
}

fun maxOf_1(a: Int, b: Int): Int = if (a > b) a else b

fun maxOf_2(a:Int,b:Int) = if (a > b) a else b

fun minOf(a: Int, b: Int): Int {
    if (a > b) {
        return b
    }else {
        return a
    }
}

fun minOf_1(a:Int,b:Int):Int = if (a > b) b else a

fun  minOf_2(a:Int,b:Int) = if(a > b) b else a


fun parseInt(str:String):Int? {
    return str.toIntOrNull()
}


fun printlnMultiplyResult(arg1: String, arg2: String):Unit {
    val x = parseInt(arg1)
    val y = parseInt(arg2)
    // Using `x * y` yields error because they may hold nulls.
    if (x != null && y != null) {
        // x and y are automatically cast to non-nullable after null check
        println(x * y)
    } else {
        println("either '$arg1' or '$arg2' is not a number")
    }
}




fun printlnMultiplyResultTwo(arg1: String, arg2: String):Unit {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    if (x == null) {
        println("Wrong number format in arg1: '$arg1'")
        return
    }

    if (y == null) {
        println("Wrong number format in arg2: '$arg2'")
        return
    }

    // x and y are automatically cast to non-nullable after null check
    println(x * y)
}