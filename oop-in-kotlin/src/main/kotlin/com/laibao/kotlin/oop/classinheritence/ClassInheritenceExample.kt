package com.laibao.kotlin.oop.classinheritence

fun main() {

    val car = Car("Toyota")
    val lexus = Lexus("Lexus")
    val honda = Honda("honda")

    car.showBrand()

    lexus.showBrand()

    honda.showBrand()
}

open class Car(brand:String) {
    private val brand:String = brand
    fun showBrand() = println("the car's brand is $brand")
}

class Lexus: Car {
    constructor(brand: String):super(brand)
}

class Honda:Car {
    constructor(brand: String):super(brand)
}