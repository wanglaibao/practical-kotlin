package com.laibao.kotlin.basic.smartcast

fun main() {

    val dog1:Dog = SheepHerdDog()
    //dog1.herbSheep()

    if (dog1 is SheepHerdDog) {
        dog1.herbSheep()
    }


    val dog2:Dog = RuralDog()
    //dog2.keepHouse()
    if (dog2 is RuralDog) {
        dog2.keepHouse()
    }


}

abstract class Dog() {

}

class SheepHerdDog : Dog(){

    fun herbSheep() {
        println("牧羊犬放羊")
    }
}

class RuralDog : Dog() {

    fun keepHouse() {
        println("普通狗看家")
    }
}