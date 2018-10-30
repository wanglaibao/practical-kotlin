package com.laibao.kotlin.basic.loop

/**
 * @author laibao wang
 *
 * forEach can be used to loop each element in an iterable
 */

fun main(args: Array<String>) {
    testForEach()
}

fun testForEach():Unit {
    var monthsOfYear = listOf("一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月")
    monthsOfYear.forEach { month -> println(month) }
    println()
}
