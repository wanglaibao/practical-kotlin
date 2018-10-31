package com.laibao.kotlin.basic.oop.classes

/**
 * @author laibao wang
 */
class Employee (val name:String,val age:Int){

    // instance variables
    private var salary:Int? = null

    // secondary constructor
    constructor(name: String,age: Int,salary:Int):this(name,age) {
        this.salary = salary
    }

    // instance method (or routine or function)
    fun printEmployeeDetails(){
        println("$name whose salary is $salary, is $age years old.")
    }

    fun getSalary():Int? = salary
}