package com.laibao.kotlin.basic.range

fun main() {

    val intRange:IntRange = 1 .. 10000

    for (element in intRange) {
        println("element is $element")
    }



    for ((index:Int,element:Int) in intRange.withIndex()) {
        println("the index is $index and the element is $element")
    }


    intRange.forEach{println(it)}
    println()


    intRange.forEachIndexed { index, element ->  println("the index is $index and the element is $element")}

}