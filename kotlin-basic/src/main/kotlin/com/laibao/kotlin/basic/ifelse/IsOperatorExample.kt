package com.laibao.kotlin.basic.ifelse

/**
 * @author laibao wang
 */

fun main(args: Array<String>) {
    println(getStringLength(" "))
    println(getStringLength_1("sfasdfasfd"))
    println(getStringLength_2("  "))
    println(getStringLength_2("sfsafdsafdasdfafasdf"))
}

fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        // `obj` is automatically cast to `String` in this branch
        return obj.length
    }
    // `obj` is still of type `Any` outside of the type-checked branch
    return null
}

fun getStringLength_1(obj: Any): Int? {
    if (obj !is String) return null
    // `obj` is automatically cast to `String` in this branch
    return obj.length
}

fun getStringLength_2(obj: Any): Int? {
    // `obj` is automatically cast to `String` on the right-hand side of `&&`
    if (obj is String && obj.length > 0) {
        return obj.length
    }
    // `obj` is still of type `Any` outside of the type-checked branch
    return null
}

