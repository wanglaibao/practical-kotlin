package com.laibao.kotlin.basic.`when`

/**
 * @author laibao wang
 */

fun main(args: Array<String>) {
    val score = 'B'
    when (score) {
        'A','B' -> {
            println("你好啊")
            println("你很好啊")
        }
        'C','D','E' -> {
            println("你的确很好看")
            println("你的确很好看")
        }
        else -> {
            println("dfgdsgsad")
            println("")
        }
    }
}
