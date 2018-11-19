package com.laibao.kotlin.basic.basedatatype

/**
 * @author laibao wang
 */

fun main(args: Array<String>) {
    val str = "Hello, world!\n"
    println(str)
    val text = """for (c in "foo")print(c)"""
    println(text)
    println()

    val text1 = """for (c in "foo")
                    print(c)
                """
    println(text1)

    val text2 = """
                    for (c in "foo")
                    print(c)
                """
    println(text2)

    val text3 = """
|Tell me and I forget.
|Teach me and I remember.
|Involve me and I learn.
|(Benjamin Franklin)
"""
    println(text3)

    val text4 = """
                                                            |Tell me and I forget.
                                        |Teach me and I remember.
                                    |Involve me and I learn.
                        |(Benjamin Franklin)
                """.trimMargin()
    println(text4)


    val i = 10
    // prints "i = 10"
    println("i = $i")

    val abc = "abc"
    // prints "abc.length is 3"
    println("$abc.length is ${abc.length}")
}
