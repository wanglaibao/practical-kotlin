package com.laibao.kotlin.basic.destruct

/**
 * @author laibao wang
 */

fun main(args: Array<String>) {

    val map = mapOf(1 to "one", 2 to "two")
    // before
    println(map.mapValues { entry -> {
                                        val (key, value) = entry
                                        "$key -> $value!"
                                        }
    })
    println()
    // now
    println(map.mapValues { (key, value) -> "$key -> $value!" })
}






