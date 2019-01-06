package com.laibao.kotlin.basic

import java.text.SimpleDateFormat
import java.util.*

/**
 * @author laibao wang
 */
fun main(args: Array<String>) {
    println("Hello World !")
    println(SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date()))
    testIfConditions()
    println()
    testIfExpress()
    testWhenExpress()

    println("Int.MIN_VALUE is " +Int.MIN_VALUE);
    println("Int.MAX_VALUE is " + Int.MAX_VALUE)

    val intValue:Int = (Math.pow(2.0,31.0) -1).toInt()
    println("the value of intValue is $intValue")

    val persons:List<Person> = listOf(Person("jinge",21), Person("alading"), Person("qiancheng",31))


    args.forEach Foreach@{ if(it == null) return@Foreach
                            println(it)
    }

    persons.forEach {
        if (it == null) return@forEach
        println(it)
    }

    val oldest = persons.maxBy {it -> it.age?: 0}
    println("the oldest person is ${oldest?.name} and old is ${oldest?.age}")

    for (number in 1 ..100) {
        println(fizzBuzz(number))
    }

    for (number in 1000 downTo 1 step 2) {
        println(number)
        println(fizzBuzz(number))
    }

    for (c in 'A' .. 'Z') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }

    //迭代map
    for ((key,value) in binaryReps) {
        println("$key = $value")
    }

    println()
    println()

    println(ollAddRec(100,0))

    println(ollMultiRec(10,1))
}

fun testIfConditions() {
    val age = 45
    if (age >= 60) {
        println("老年人")
    }else if (age >= 40 && age < 60) {
        println("中年人")
    }else if (age >= 20 && age < 40) {
        println("青年人")
    } else{
        println("少年人")
    }
}

fun testIfExpress() {
    var age = 20
    //将if表达式赋值给str变量
    var str = if (age > 20) "age 大于 20" else if (age < 20) "age小于20" else "等于20"
    println(str)
}

fun testWhenExpress() {
    val score = 'B'
    when(score){
        'A' -> println("优秀")
        'B' -> println("良好")
        'C' -> println("中等")
        'D' -> println("一般")
        'E' -> println("及格")
        else -> println("不合格")
    }
}

data class Person(val name:String,val age:Int? = null)

class Rectangle(val height:Int,val width:Int) {
    val isSquare:Boolean
        get() = height == width
}



fun fizzBuzz(number:Int) = when {
    number % 15 == 0 -> "FizzBuzz"
    number % 3 == 0 -> "Fizz"
    number % 5 == 0 -> "Buzz"
    else -> "$number"
}

fun recognize(c:Char) = when {
     c in '0' .. '9'  -> "it is a digit"
     c in 'A' .. 'Z'  -> "it is a letter"
    else -> "other value"
}

enum class Color {
    RED,
    GREEN,
    BLUE
}

val binaryReps: TreeMap<Char,String> = TreeMap()


fun ollAdd(number:Int):Int = if (number <= 1) 1 else number + ollAdd(number -1)

tailrec fun ollAddRec(number:Int,sum:Int):Int = if (number == 0) sum else ollAddRec(number-1,sum+number)

tailrec fun ollMultiRec(number:Int,multi:Int):Int = if (number == 1) multi else ollMultiRec(number-1,multi * number)
