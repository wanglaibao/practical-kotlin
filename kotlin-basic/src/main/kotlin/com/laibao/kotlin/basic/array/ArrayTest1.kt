package com.laibao.kotlin.basic.array

import java.util.*

fun main() {

    val arr1:Array<Int> = arrayOf(1,2,3,4,5,6,7,8,9,10)

    val arr2:Array<Double> = arrayOf(12.3,21.3,345.12)

    val arr3:Array<Char> = arrayOf('a','b','c')

    val arr4:Array<String> = arrayOf("asfdasf","asfdasfd","asfasfd")

    val arr5:Array<Any> = arrayOf("asfdasfd",123123,"asdfasfd",2121.34,Date())


    /**
     * 下面是几种基本数据类型的数组
     */

    val intArr = intArrayOf(1,2,3,4,5,6)
    val intArr2 = IntArray(100){i -> i + 1}

    intArr2.forEach { println(it) }
}