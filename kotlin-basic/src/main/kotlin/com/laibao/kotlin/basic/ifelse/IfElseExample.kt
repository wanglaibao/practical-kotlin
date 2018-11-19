package com.laibao.kotlin.basic.ifelse

/**
 * @author laibao wang
 */

fun main(args: Array<String>) {
    println(maxOf(100,200))
    println()
    println(minOf(10000,20000))
}

fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    }else {
        return b
    }
}

fun minOf(a: Int, b: Int): Int {
    if (a > b) {
        return b
    }else {
        return a
    }
}
