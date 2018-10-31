package com.laibao.kotlin.basic.oop.inheritance

/**
 * @author laibao wang
 *
 * Person is a Parent Class
 */
open class Person (val name: String = "金戈",val role: String = "Person"){

    fun eat(): Unit{
        println(name + " is eating.")
    }

    fun sleep():Unit{
        println(name + " is sleeping.")
    }

    open fun love():Unit {
        println(name + " is loving")
    }

    open fun marry():Unit {
        println(name + " is marring")
    }



}