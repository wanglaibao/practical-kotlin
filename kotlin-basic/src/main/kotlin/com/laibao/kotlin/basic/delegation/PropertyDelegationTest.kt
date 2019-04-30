package com.laibao.kotlin.basic.delegation

import kotlin.reflect.KProperty

fun main() {
    val son = Son()
    son.lunarMoney = 500

    println(son.lunarMoney)
}

class Son {
    var lunarMoney:Int by Mother()
}

class Mother {

    var sunlunarMoney = 0

    var xiaoJinKu:Int = 0
   


    operator fun setValue(son: Son, property: KProperty<*>, intValue: Int) {
            sunlunarMoney += 100
            xiaoJinKu += intValue - 100
    }

    operator fun getValue(son: Son, property: KProperty<*>): Int {
           return sunlunarMoney
    }


}