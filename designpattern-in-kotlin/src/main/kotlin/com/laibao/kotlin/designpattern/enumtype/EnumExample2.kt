package com.laibao.kotlin.designpattern.enumtype

fun main() {
    val color = ComplexColor.BLUE
    val rValue =color.r
    val gValue = color.g
    val bValue = color.b

    //println("$rValue,$gValue,$bValue")


    //printHex(ComplexColor.BLUE.rgb())
    //printHex(ComplexColor.ORANGE.rgb())
    //printHex(ComplexColor.GRAY.rgb())


    for (color in enumValues<ComplexColor>()) {
        println("name: ${color.name}, ordinal: ${color.ordinal}")
      //  println(color.rgb())
        color.printlnColor()
    }

}


enum class Temperature { COLD, NEUTRAL, WARM }

enum class ComplexColor constructor(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0){
        override val temperature: Temperature = Temperature.WARM

        override fun printlnColor() {
            println("the color is $name")
        }
    },

    ORANGE(255, 165, 0){
        override val temperature = Temperature.WARM

        override fun printlnColor() {
            println("the color is $name")
        }
    },

    BLUE(0, 0, 255){
        override val temperature = Temperature.COLD

        override fun printlnColor() {
            println("the color is $name")
        }
    },

    GRAY(49, 79, 79){
        override val temperature = Temperature.NEUTRAL

        override fun printlnColor() {
            println("the color is $name")
        }
    },

    VIOLET(238, 130, 238){
        override val temperature = Temperature.COLD

        override fun printlnColor() {
            println("the color is $name")
        }
    };

    init {
        require(r in 0..255)
        require(g in 0..255)
        require(b in 0..255)
    }

    fun rgb() = r shl 16 + g shl 8 + b

    abstract val temperature: Temperature

    abstract fun printlnColor()
}


fun printHex(num: Int) {
    println(num.toString(16))
}