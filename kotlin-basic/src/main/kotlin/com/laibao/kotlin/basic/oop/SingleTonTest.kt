package com.laibao.kotlin.basic.oop

fun main() {
    println(Utils.name)
    println(Utils.apply().age)
}

class Utils private constructor() {

    val age:Int = 200

    companion object {

        val name:String = "金戈"

        private val instance:Utils by lazy { Utils() }

        fun apply():Utils {
            return instance
        }
    }
}