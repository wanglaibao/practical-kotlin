package com.laibao.kotlin.basic.oop.abstraction

/**
 * @author laibao wang
 */
abstract class Human {
    // initialized variable
    val category : String = "White"

    // abstract variable
    abstract val food : String

    // function with body
    fun eat() {
        println("The Human, $category, like to eat $food")
    }
    // abstract function
    abstract fun drink()
}