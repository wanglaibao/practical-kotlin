package com.laibao.kotlin.basic.nulltypesafe

import org.apache.commons.lang3.StringUtils

/**
 * @author laibao wang
 */

fun main(args: Array<String>) {
    var str: String?  = "afdafafasdf"
    //先判断str不为null，然后访问str的length属性
    val len = if (StringUtils.isNotEmpty(str)) str!!.length else -1
    println("str 的长度为: ${len}")
    str = null

    if (StringUtils.isNotEmpty(str) && str!!.length > 0) {
        // 访问str的length属性
        println(str.length)
    }else {
        println("空字符串")
    }

    println("------------------------")
    println("------------------------")
    println()
    invokeSafeLy()
    println()
    println()
    testLet()
}

fun invokeSafeLy() {
    var strValue: String? = "asfdasfdasfdasfdasfasf"
    println(strValue?.length)
    strValue = null
    println(strValue?.length)
}

fun testLet() {
    //定义一个元索可空的数组
    val myArr : Array<String?> = arrayOf ("java","kotlin",null,"groovy", "scala")
    for (element in myArr) {
        element?.let { println(element) }
    }

    var str: String? = "sadfasdf"
    println(str?.length)

    str?.forEach { element -> println(element) }

}