package com.laibao.kotlin.basic.oop

import com.laibao.kotlin.basic.oop.sealedclasses.*

/**
 * Created by A on 2018/10/31.
 */

/*
        A Sealed Class have specific number of sub-classes.
 */

/*
        Location
        All the classes that directly inherit a sealed class should be present in the same Kotlin file
 */

/*
        Constructors
        Sealed Class cannot have non-private constructors
        Private is the default access modifier for constructors in Sealed Class.
 */

/*
        Abstract
        By default, a Sealed Class is abstract
        Hence, a Sealed Class cannot be instantiated and all other properties pertaining to Abstract Class hold for a Sealed Class
 */


fun main(args: Array<String>) {

    val addition: ArithmeticOperation = Add(40, 20)
    val subtraction: ArithmeticOperation = Subtract(40, 20)
    val multiplication: ArithmeticOperation = Multiply(40, 20)
    val division: ArithmeticOperation = Divide(40, 20)

    val addResult = executeOperation(addition)
    val subtractionResult = executeOperation(subtraction)
    val multiplicationResult = executeOperation(multiplication)
    val divisionResult = executeOperation(division)

    println("addResult is ${addResult}")
    println("subtractionResult is ${subtractionResult}")
    println("multiplicationResult is ${multiplicationResult}")
    println("divisionResult is ${divisionResult}")
}