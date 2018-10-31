package com.laibao.kotlin.basic.oop.classes

/**
 * @author laibao wang
 */
class Student(var name: String, var age: Int) {
    // initializer block is run during the initialization of class object, after executing constructor
    init{
        println("$name's details are being held in this class object.")
    }

    private var major:String? = null

    constructor (name: String, age: Int, profession: String) : this(name, age){
        this.major = major
    }
}