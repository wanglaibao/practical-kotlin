package com.laibao.kotlin.basic.array

fun main() {
    val arr1:Array<Int> = arrayOf(1,2,3,4,5,6,7,8,9,10)

    val arr2:Array<Double> = arrayOf(12.3,21.3,345.12)

    val arr3:Array<Char> = arrayOf('a','b','c')

    val arr4:Array<String> = arrayOf("张三","李四","张四","王五","张三","赵六")

    val index1:Int = arr4.indexOf("张三")
    println("the index1 is $index1")

    val index2:Int = arr4.lastIndexOf("张三")
    println("the index2 is $index2")


    val index3 = arr4.indexOfFirst { it.startsWith("张三") }

    val index4 = arr4.indexOfLast{ it.startsWith("张三") }

    println("the index3 is $index3")

    println("the index4 is $index4")
}