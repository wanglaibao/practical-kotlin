package com.laibao.kotlin.designpattern.singleton

fun main() {

}

enum class EnumSingleTon{

    INSTANCE;

    fun getInstance() = INSTANCE
}