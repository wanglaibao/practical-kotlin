package com.laibao.kotlin.basic.loop

/**
 * @author laibao wang
 *
 * forEach can be used to loop each element in an iterable
 */

fun main(args: Array<String>) {
    testForEach()

    for (i in 1..3) {
        println(i)
    }
    for (i in 6 downTo 0 step 2) {
        println(i)
    }



    val array = intArrayOf(1,2,3,4,5,6,7,8,9,10)

    val numberArr = IntArray(100,{i ->  i})

    for (i in array.indices) {
        println(array[i])
    }
    println()
    for (i in numberArr.indices) {
        println(numberArr[i])
    }

    // Alternatively, you can use the withIndex library function
    for ((index, value) in numberArr.withIndex()) {
        println("the element at $index is $value")
    }
}

fun testForEach():Unit {
    var monthsOfYear = listOf("一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月")
    monthsOfYear.forEach { month -> println(month) }
    println()
}
