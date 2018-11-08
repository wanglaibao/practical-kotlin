package com.laibao.kotlin.basic.operator

/**
 * @author laibao wang
 */

fun main(args: Array<String>) {
    var str = "think in kotlin"
    //调用String的contains方法判断
    println(str.contains("kotlin"))
    //使用in运算符判断
    println("kotlin" in str)

    val array= arrayOf(24 , 45 , 100 , - 3, 30)
    //调用Array的contains方法判断
    println(array.contains(100))

    //使用in 运算符判断
    println(100 in array)

    //使用 !in 运算符判断
    println(100 !in array)

}
