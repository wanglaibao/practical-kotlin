package com.laibao.kotlin.basic.dataclass


fun main() {
    val evalValue = eval(Sum(Const(100.0), Const(200.0)))

    println(evalValue)
}

sealed class Expr

data class Const(val number: Double) : Expr()

data class Sum(val e1: Expr, val e2: Expr) : Expr()

object NotANumber : Expr()

fun eval(expr: Expr): Double = when (expr) {
    is Const -> expr.number
    is Sum -> eval(expr.e1) + eval(expr.e2)
    NotANumber -> Double.NaN
}


