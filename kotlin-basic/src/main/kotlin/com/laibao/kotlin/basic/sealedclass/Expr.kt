package com.laibao.kotlin.basic.sealedclass

/**
 * @author laibao wang
 */
sealed class Expr
class Const(val number: Double):Expr()
class Sum(val e1: Expr, val e2: Expr):Expr()
object NotANumber : Expr()
fun eval(expr: Expr): Double = when (expr) {
    is Const -> expr.number
    is Sum -> eval(expr.e1) + eval(expr.e2)
    NotANumber -> Double.NaN
}

val e = eval(Sum(Const(1.0), Const(2.0)))


