package com.laibao.kotlin.basic.operator

/**
 * @author laibao wang
 */

/*
        单目前缀运算符有＋、－、！这三个
        +  <===>  unaryPlus()
        -  <===>  unaryMinus()
        !  <===>  not()
 */

fun main(args: Array<String>) {
    val a = 20;
    //使用运算符
    val b = -a;
    //调用方法
    val c = a.unaryMinus();
    println("b: ${b}, c: ${c}");

    val flag = true
    //使用运算符
    val notFlag1 = !flag
    //调用方法
    val notFlag2 = flag.not()
    println ("notFlagl: ${notFlag1},notFlag2: $notFlag2}")

    val m = 100
    //使用运算符
    val n = +m;
    //调用方法
    val k = m.unaryPlus()
    println("n: ${n}, k: ${k}");
}