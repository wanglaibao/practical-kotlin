package com.laibao.kotlin.basic.`package`

/**
 * @author laibao wang
 */

/*
        A source file may start with a package declaration
 */
class Goo

fun baz():Unit {
    println("it is a baz")
}

/*
    Default Imports Default Imports Default Imports Default Imports

    1: A number of packages are imported into every Kotlin ?le by default:
            kotlin.*
            kotlin.annotation.*
            kotlin.collections.*
            kotlin.comparisons.* (since 1.1)
            kotlin.io.*
            kotlin.ranges.*
            kotlin.sequences.*
            kotlin.text.*
    2: Additional packages are imported depending on the target platform
        JVM:
            java.lang.*
            kotlin.jvm.*
        JS:
            kotlin.js.*
 */