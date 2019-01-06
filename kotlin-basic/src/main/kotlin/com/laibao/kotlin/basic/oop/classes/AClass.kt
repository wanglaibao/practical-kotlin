package com.laibao.kotlin.basic.oop.classes


class AClass {
    var age:Int = 0
        get() {return field}

        set(value) {this.age = value}

    var name:String = ""
        get() {return field}
        set(value) {this.name = value}
}