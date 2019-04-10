package com.laibao.kotlin.basic.oop.inheritance


fun main() {
    val dog:Animal = Dog()

    val cat:Animal = Cat()

    dog.call()
    cat.call()

    dog.eat()
    cat.eat()
}

//动物
abstract class Animal {

    val color:String = ""

    //行为
    abstract fun call()

    open fun eat() {
        println("吃饭了")
    }
}

class Dog:Animal() {

    override fun call() {
        println("汪汪叫")
    }

    override fun eat() {
        println("我是狗我要吃狗娘")
    }
}

class Cat : Animal() {
    override fun call() {
        println("喵喵叫")
    }

    override fun eat() {
        println("我是猫，我要吃猫食")
    }
}