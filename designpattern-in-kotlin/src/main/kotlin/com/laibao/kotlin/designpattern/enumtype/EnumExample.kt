package com.laibao.kotlin.designpattern.enumtype

fun main() {
    val favouriteColor = SimpleColor.BLUE
    println(favouriteColor)


    val selectedColor = SimpleColor.valueOf("ORANGE")
    println(selectedColor == SimpleColor.ORANGE) // prints: true


    //to use Kotlin helper method
    val selectedColor1 = enumValueOf<SimpleColor>("VIOLET")
    println(selectedColor == SimpleColor.BLUE) // prints: false


    //To display all values in the SimpleColor enum, use values function
    for (color in SimpleColor.values()) {
        println("name: ${color.name}, ordinal: ${color.ordinal}")
    }

    // Or the Kotlin enumValues helper method
    for (color in enumValues<SimpleColor>()) {
        println("name: ${color.name}, ordinal: ${color.ordinal}")
    }
}

enum class SimpleColor {
    RED,
    ORANGE,
    BLUE,
    GRAY,
    VIOLET
}