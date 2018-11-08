package com.laibao.kotlin.basic.`when`

/**
 * @author laibao wang
 */
fun main(args: Array<String>) {
    val score = 'B'
    when (score) {
        'A' -> {
            println("你好啊")
            println("你很好啊")
        }
        'B' -> {
            println("你很漂亮啊")
            println("你很漂亮啊")
        }
        'C' -> {
            println("你的确很好看")
            println("你的确很好看")
        }
        'D' -> {
            println("你美么")
            println("你美么")
        }
        'E' -> {
            println("我不漂亮啊")
            println("我不漂亮啊")
        }
        else -> {
            println("dfgdsgsad")
            println("")
        }
    }
}
