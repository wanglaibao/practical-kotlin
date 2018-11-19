package com.laibao.kotlin.basic.basedatatype

/**
 * @author laibao wang
 */

fun main(args: Array<String>) {
    // A boxed Int (java.lang.Integer)
    val a: Int? = 1

    // implicit conversion yields a boxed Long (java.lang.Long)
    val b: Long? = a?.toLong()
    //println(a == b) //因为类型不匹配所以无法比较相等性

    //OK, literals are checked statically
    val byteNumber: Byte = 1 //

    //ERROR 因为类型不匹配所以赋值
    //val i: Int = byteNumber

    // We can use explicit conversions to widen numbers
    // OK: explicitly widened
    val i: Int = byteNumber.toInt()
    print(i)
}


/*
  Every number type supports the following conversions:
        toByte(): Byte
        toShort(): Short
        toInt(): Int
        toLong(): Long
        toFloat(): Float
        toDouble(): Double
        toChar(): Char
 */

/*
        Basic Type 包括如下几种
        1：数值类型【Number】 Byte Short Int Long Float Double
        2：字符类型【Char】   Char
        3：布尔类型【Boolean】  Boolean
        4：字符串类型【String】  String
 */
