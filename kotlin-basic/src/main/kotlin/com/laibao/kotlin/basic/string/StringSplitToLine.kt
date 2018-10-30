package com.laibao.kotlin.basic.string

/**
 * @author laibao wang
 */
fun main(args: Array<String>) {
    testSplitToLines()
}
/**
 *  Split String to Lines
 *  To split string to lines in Kotlin programming, we may use String.lines() function.
 *
 *  The function lines() : splits the char sequence to a list of lines
 *  delimited by any of the following character sequences: Carriage-Return Line-Feed, Line-Feed or Carriage-Return.
 */


/**
 * Syntax of String.lines() function
 * fun CharSequence.lines(): List<String> (source)
 */


fun testSplitToLines() {
    // string to be split to lines
    val str: String = "Kotlin Tutorial.\nLearn Kotlin Programming with Ease.\rLearn Kotlin Basics.\nWang jinwei lai le."

    // splitting string using lines() function
    val lines: List<String> = str.lines()

    // printing lines
    lines.forEach { strValue -> println(strValue) }
}