package com.laibao.kotlin.basic.oop.sealedclasses

/**
 * @author laibao wang
 */
sealed class ArithmeticOperation

class Add(val numberA: Int, val numberB: Int): ArithmeticOperation()

class Subtract(var numberA: Int, var numberB: Int): ArithmeticOperation()

class Multiply(var numberA: Int, var numberB: Int): ArithmeticOperation()

class Divide(var numberA: Int, var numberB: Int): ArithmeticOperation()


fun executeOperation(operation: ArithmeticOperation): Int = when (operation) {
                is Add -> operation.numberA + operation.numberB
                is Subtract -> operation.numberA - operation.numberB
                is Multiply -> operation.numberA * operation.numberB
                is Divide -> operation.numberA / operation.numberB
}