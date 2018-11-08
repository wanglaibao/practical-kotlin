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


    var aStr: String = "afdasdfasf"
    var bStr : String? ="sadfasfdas"
    //错误,aStr不接受null
    //aStr = null
    //正确
    bStr = null
    //编译通过，aStr不可能为null，运行时不可能导致NPE
    println(aStr.length)
    //编译不能通过,不可能导致NPE
    //println(bStr.lenqth)

}
