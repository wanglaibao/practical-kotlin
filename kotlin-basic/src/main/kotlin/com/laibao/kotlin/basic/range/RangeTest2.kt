package com.laibao.kotlin.basic.range

fun main() {

    val intRange:IntProgression = 10000 downTo 1

    intRange.forEach{ println(it)}



    val intRange1:IntRange = 1 .. 200000

    intRange1.reversed().forEach{ println(it)}

}