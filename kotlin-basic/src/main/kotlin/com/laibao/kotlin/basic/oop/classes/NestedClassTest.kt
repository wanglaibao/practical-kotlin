package com.laibao.kotlin.basic.oop.classes

fun main() {

    val nestedClassIstance = OuterClass.InnerClass()
    nestedClassIstance.sayHello()

    val innerClass1 = OuterClass().InnerClass1()
    innerClass1.sayHello()
}

class OuterClass {
    val name:String = "金戈"

    class InnerClass {
        fun sayHello() {
           // println("你好啊,$name")
            println("你好啊")
        }
    }


    inner class InnerClass1 {
        val name:String = "阿拉丁"
        fun sayHello() {
             println("你好啊,$name")

            println("你好啊,${this.name}")

            println("你好啊,${this@OuterClass.name}")
        }
    }
}