package com.laibao.kotlin.basic.nulltypesafe

/**
 * @author laibao wang
 */

fun main(args: Array<String>) {
    val strValue = "jinge"
    val numberValue = "123131"
    println(strValue.toIntOrNull())
    println(numberValue.toIntOrNull())

    if (strValue.toIntOrNull() == null) {
        println("不是数字类型的字符串")
    }else {
        println("是数字类型的字符串")
    }
}
