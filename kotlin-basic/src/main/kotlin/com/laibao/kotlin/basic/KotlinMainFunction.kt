package com.laibao.kotlin.basic

/**
 * @author laibao wang
 * main function in kotlin
 */

data class User(val name: String, val age: Int)

fun printUser(user: User): Unit {
    println("user name is ${user.name} and user age is ${user.age}")
}

/**
 * main() function is an entry point to Kotlin program
 */
fun main(args: Array<String>) {
    val user: User = User("金戈",30)
    printUser(user)
}



