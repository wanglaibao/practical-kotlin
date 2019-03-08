package com.laibao.kotlin.designpattern.staticfactorymethod

fun main() {
    val hopefullyNumber = NumberMaster.valueOf("1234567890")

    println(hopefullyNumber)

    //println(NumberMaster().valueOf("123")) // Won't compile



    // This won't compile
    //val instance = MyClass()
    // But this works as it should
    val instance = MyClass.create()
    println(instance)
}

class NumberMaster {
    companion object {
        fun valueOf(hopefullyNumber: String) : Long = hopefullyNumber.toLong()
    }
}


class MyClass private constructor() {
    companion object {
        fun create(): MyClass {
            return MyClass()
        }
    }
}