package com.laibao.kotlin.designpattern.decorator

fun main() {

    // usage
    Text("Hello").run {
        underline {
            draw()
        }
    }
}

class Text(val text: String) {
    fun draw() = println(text)
}


fun Text.underline(decorated: Text.() -> Unit) {
    println("--------------")
    this.decorated()
    println("--------------")
}