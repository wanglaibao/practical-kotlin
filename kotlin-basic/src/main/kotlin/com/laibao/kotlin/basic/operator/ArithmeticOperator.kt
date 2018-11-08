package com.laibao.kotlin.basic.operator

/**
 * @author laibao wang
 */

/*

        算术运算符
            +      <====>      plus()
            -      <====>      minus()
            *      <====>      times()
            /      <====>      div()
            %      <====>      rem()
            ..     <====>      rangeTo()

 */


fun main(args: Array<String>) {
    //加法运算
    println(5 + 6)
    println(5.plus(6))

    //减法运算
    println(100 - 20)
    println(100.minus(20))

    //乘法运算
    println(20 *30)
    println(200.times(300))

    //除法运算
    println(1000 / 20)
    println(1000.div(20))


    //求余运算
    println(25  % 12)
    println(25.rem(12))

    // 区间运算
    println(50 .. 100)
    println(50.rangeTo(100))
}
