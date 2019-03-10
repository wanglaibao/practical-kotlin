package com.laibao.kotlin.oop.withexpression

fun main() {
    val oracle = Oracle();

    with(oracle){
        connect()
        update()
        close()
    }
}

class Oracle() {

    fun connect():Unit {
        println("数据库连接")
    }

    fun update():Unit {
        println("数据库更新")
    }

    fun close():Unit {
        println("数据库关闭")
    }
}