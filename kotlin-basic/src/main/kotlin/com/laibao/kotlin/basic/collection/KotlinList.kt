package com.laibao.kotlin.basic.collection

/**
 * @author laibao wang
 */
data class Book(val name: String = "", val price: Int = 0)

val listA: List<String> = listOf<String>("Example", "Program", "Tutorial")

val listB: MutableList<String> = mutableListOf("Example", "Program", "Tutorial")

fun main(args: Array<String>) {
    testGet()
    testForLoop()
    testForEach()
    testAdd()
    testFilter()
    testMap()
    testContains()
    testFind()
}


fun  testGet() {
    println(listA[0])
    println()
    println(listA.get(2))
    println()

    println(listB[0])
    println()
    println(listB[1])
}

fun testForLoop () {
    for (element in listA) {
        println("element in listA is $element")
    }
    println()

    for ((index,value) in listA.withIndex()) {
        println("the index is $index and the value is $value")
    }
    println()

    for (element in listB) {
        println("element in listB is $element")
    }
    println()
    for ((index,value) in listB.withIndex()) {
        println("the index is $index and the value is $value")
    }
}

fun testForEach() {
    listA.forEach { elementA -> println("the elementA is $elementA") }
    println()
    listB.forEach { elementB -> println("the elementB is $elementB")  }
    println()

    val book1 = Book("Kotlin Tutorial")
    val book2 = Book("Scala Tutorial", 2)
    val book3 = Book("Groovy Tutorial",3)
    val book4 = Book("Java8 Tutorial",4)

    val listC: List<Book> = listOf<Book>(book1, book2,book3,book4)

    listC.forEach { book -> println("Price of book, ${book.name} is ${book.price}") }
}

fun testAdd() {
    val list: MutableList<String> = listA.toMutableList()
    list.add("金戈")
    list.forEach {element -> println(element) }
    println()

    listB.add("张无忌")
    listB.forEach { element -> println(element) }
    println()
}

fun testFilter() {
    listA.filter { strValue -> strValue.length > 4 }
            .forEach { element -> println(element) }
    println()
    listB.filter { strValue -> strValue.length < 10 && strValue.length > 7 }
            .forEach { element -> println(element) }
}

fun testMap() {
    listA.map { strValue -> strValue.length }
            .forEach { number -> println(number) }
    println()
    listB.map { strValue -> strValue.toUpperCase()}
            .forEach { element -> println(element) }
}

fun testContains() {
    var list: List<String> = listOf<String>("Example", "Program", "Tutorial")

    val flag: Boolean = list.contains("Program")

    if(flag){
        println("Program is present in the list.")
    } else{
        println("Program is not present in the list.")
    }
}

fun testFind() {
    var list: List<String> = listOf<String>("Example", "Program", "Tutorial")
    val strValue: String? = listA.find { it.contains("am") }
    println(strValue)

}