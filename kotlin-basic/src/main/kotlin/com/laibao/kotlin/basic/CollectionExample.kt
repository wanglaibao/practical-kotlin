package com.laibao.kotlin.basic

/**
 * Created by A on 2018/12/6.
 */
fun main(args: Array<String>) {
    //val list = listOf<Int>(1,2,4,5,6,7)
    val list1 = arrayListOf<Int>(1,2,4,5,6,7)
    val set = setOf<Double>(2.3,4.5)
    val set1 = hashSetOf<Double>(2.3,4.5)

    val map = hashMapOf<Int,String>(1 to "One",2 to "Two",3 to "Three")
    //println(list.javaClass)
    println(list1.javaClass)
    println(set.javaClass)
    println(set1.javaClass)
    println(map.javaClass)
    println()
    println()

    println("list1.last(): "+list1.last())
    println("list1.first(): "+list1.first())
    println("list1.max(): "+list1.max())

    println("set.last(): "+set.last())
    println("set.first(): "+set.first())
    println("set.max(): "+set.max())

    println("set1.last(): "+set1.last())
    println("set1.first(): "+set1.first())
    println("set1.max(): "+set1.max())

   // println("map.last(): "+map.last())
   // println("map.first(): "+map.first())
   // println("map.max(): "+map.max())
}