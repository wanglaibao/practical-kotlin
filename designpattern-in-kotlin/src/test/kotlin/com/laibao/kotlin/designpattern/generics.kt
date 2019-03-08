package com.laibao.kotlin.designpattern

fun main() {
    val listOfStrings = mutableListOf("a", "b", "c")

    for (element in listOfStrings) {
        println(element)
    }
    println()

    listOfStrings.forEach(::println)
    println()

    listOfStrings.forEach{ println(it)}
}