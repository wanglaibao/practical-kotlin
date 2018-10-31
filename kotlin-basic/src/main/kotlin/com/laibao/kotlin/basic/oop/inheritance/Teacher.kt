package com.laibao.kotlin.basic.oop.inheritance

/**
 * @author laibao wang
 * Teacher class inherits Person class
 */
class Teacher(name:String) : Person(name,"Teacher") {

    fun doProfession(){
        println("$name is a $role. $name teaches at school.")
    }

    fun doAll(){
        eat()
        sleep()
        love()
        doProfession()
    }

    override fun love() {
        println("老师不可以跟学生恋爱的")
    }

    override fun marry() {
        println("老师是不可以跟学生结婚的啊")
    }
}