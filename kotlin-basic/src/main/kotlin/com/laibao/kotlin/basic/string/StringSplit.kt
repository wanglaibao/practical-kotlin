package com.laibao.kotlin.basic.string

/**
 * @author laibao wang
 */

fun main(args: Array<String>) {
    testSplitByDelimiter()
    println()
    testSplitByMultipleDelimiters()
    println()
    testSplitWithIgnoreCase()
    println()
    testSplitWithRegularExpression()
}

fun testSplitByDelimiter() {
    val str = "Kotlin TutorialsepTutorial KartsepExamples"
    val delimiter = "sep"
    val strList: List<String> = str.split(delimiter)
    strList.forEach { strValue -> println(strValue) }

    println()
    for (element in strList) {
        println(element)
    }

    println()
    for ((index,value) in strList.withIndex()) {
        println("index is $index and value is $value")
    }
}

fun testSplitByMultipleDelimiters() {
    val str = "Kotlin TutorialsepTutorialasepKartsepExamples"

    val delimiter1 = "sep"
    val delimiter2 = "asep"
    val delimiter3 = " "

    val strList: List<String> = str.split(delimiter1, delimiter2,delimiter3)

    strList.forEach {strValue -> println(strValue)}
}


fun testSplitWithIgnoreCase() {

    val str = "Kotlin TutorialsEPTutorialaSEpKartSEpExamples"
    val delimiter1 = "SEP"
    val delimiter2 = "ASEP"

    val list1: List<String> = str.split(delimiter1,ignoreCase = true)

    list1.forEach { strValue -> println(strValue) }
    println()

    val list2: List<String> = str.split(delimiter1,delimiter2,ignoreCase = true)
    list2.forEach { strValue -> println(strValue) }
}

fun testSplitWithRegularExpression() {
    val str = "Kotlin TutorialsepTutorialasepKartsepExamples"
    val list: List<String> = str.split(Regex("sep|asep"))
    list.forEach { strValue -> println(strValue) }
}