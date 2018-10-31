package com.laibao.kotlin.basic.oop

/**
 * @author laibao wang
 */

fun main(args: Array<String>) {
    testPerson()
}

fun testPerson() {
    val person: Person = Person("jinge",30,"男")
    println("My name is ${person.name} and my old is ${person.age} and I am a ${person.sex}")
    println()
}
