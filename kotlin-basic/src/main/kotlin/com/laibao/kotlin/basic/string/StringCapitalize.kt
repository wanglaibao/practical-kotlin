package com.laibao.kotlin.basic.string

/**
 * @author laibao wang
 */

fun main(args: Array<String>) {
    testCapitalizeFirstLetter()
    println()
    testCapitalizeFirstLetterOfEachWorld()
}


fun testCapitalizeFirstLetter() {
    val str = "kotlin tutorial examples"
    val strModified = str.capitalize()
    print(strModified)
}

fun testCapitalizeFirstLetterOfEachWorld() {
    val str = "kotlin tutorial examples"

    val words = str.split(" ")

    var stringBuilder: StringBuilder = StringBuilder()
    for(word in words){
        stringBuilder.append(word.capitalize()).append(" ")
    }
    println(stringBuilder.toString())
    println()

    var stringBuffer: StringBuffer = StringBuffer()
    words.forEach { strValue -> stringBuffer.append(strValue.capitalize()).append(" ") }
    println(stringBuffer.toString())
}






