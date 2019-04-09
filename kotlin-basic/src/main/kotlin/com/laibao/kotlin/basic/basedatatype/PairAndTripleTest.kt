package com.laibao.kotlin.basic.basedatatype

fun main() {
    val pair:Pair<String,Int> = Pair("金戈",100)
    println(pair.first)
    println(pair.second)
    println()
    val pair1 = "阿拉丁" to 123
    println(pair1.first)
    println(pair1.second)
    println()
    val triple:Triple<String,Int,String> = Triple("前程",120,"123444455")
    println(triple.first)
    println(triple.second)
    println(triple.third)
}