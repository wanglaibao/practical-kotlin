package com.laibao.kotlin.basic.operator

/**
 * @author laibao wang
 */

/*
        自增和自减运算符
            ++    <=====>   inc()
            --    <====>    dec()
 */

fun main(args: Array<String>) {
    var a = 100
    a++
    println("a: ${a}")
    println()
    a.inc()
    println("a: ${a}")
    println()
    a.dec()
    println("a: ${a}")
    println()
    --a
    println("a: ${a}")
    println()
}
