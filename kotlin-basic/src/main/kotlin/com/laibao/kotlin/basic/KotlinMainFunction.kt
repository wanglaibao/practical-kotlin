package com.laibao.kotlin.basic

/**
 * @author laibao wang
 * main function in kotlin
 */

data class User(val name: String, val age: Int)

fun printUser(user: User): Unit {
    println("user name is ${user.name} and user age is ${user.age}")
}

fun main(args: Array<String>) {
    val user: User = User("金戈",30)
    printUser(user)
}



