package com.laibao.kotlin.basic.oop.inheritance

/**
 * @author laibao wang
 *
 * Student class inherits Person class
 */
class Student(name: String): Person(name,"Student") {

    // activity function belongs to Student only
    fun doActivity(){
        println("$name is a $role. $name is studying in school.")
    }

    fun doAll(){
        eat()
        sleep()
        love()
        doActivity()
    }

    override fun love() {
        println("学生没有到18岁是不可以恋爱的")
    }

    override fun marry() {
        println("学生没有到22岁是不可以结婚的")
    }
}