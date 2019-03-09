package com.laibao.kotlin.designpattern.factorymethod

fun main() {

    val productA = FactoryA().makeProduct()
    val productB = FactoryB().makeProduct()

    productA.printlnProduct()
    productB.printlnProduct()

}

interface Product {
    val name: String

    fun printlnProduct()
}


class ProductA(override val name: String = "ProductA") : Product {
    override fun printlnProduct():Unit {
        println("the name of product is $name")
    }
}

class ProductB(override val name: String = "ProductB") : Product {
    override fun printlnProduct():Unit {
        println("the name of product is $name")
    }
}

interface Factory {
    fun makeProduct(): Product
}

class FactoryA : Factory {
    override fun makeProduct() = ProductA()
}

class FactoryB : Factory {
    override fun makeProduct() = ProductB()
}