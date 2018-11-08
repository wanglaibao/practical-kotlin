package com.laibao.kotlin.basic.nulltypesafe

/**
 * @author laibao wang
 */

fun main(args: Array<String>) {
   // 对于可空的Boolean类型而言,它可以接受3个值,即true,false或null,
   // 因此对Boolean?类型变量进行判断时,需要使用Boolean?变量显式与true,false值进行比较。
    val b: Boolean? = null
    if (b == true) {
        println("it is true")
    }else if (b == false){
        println("it is false")
    }else {
        println("it is null")
    }
}
