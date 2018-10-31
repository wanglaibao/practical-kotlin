package com.laibao.kotlin.basic.oop

import com.laibao.kotlin.basic.oop.classes.Employee
import com.laibao.kotlin.basic.oop.classes.Person
import com.laibao.kotlin.basic.oop.classes.PersonVisibilityModifier

/**
 * @author laibao wang
 */

fun main(args: Array<String>) {
    testPersonVisibilityModifier()
    testPerson()
    testEmployee()
}

fun testPerson() {
    val person: Person = Person("jinge", 30, "男")
    println("My name is ${person.name} and my old is ${person.age} and I am a ${person.sex}")
    println()
}

fun testPersonVisibilityModifier() {
    val person = PersonVisibilityModifier("宝贝", 100)
    println("${person.name},${person.age}")
    println()

    person.name = "jinge"
    person.age = 200
    println("${person.name},${person.age}")
}

fun testEmployee() {
    val employee = Employee("jinge", 30)
    employee.printEmployeeDetails()
    println()
    println("the name of employee is ${employee.name} and age is ${employee.age} and salary is ${employee.getSalary()}")
    println()
    val employee1 = Employee("jinge", 30, 2000)
    println("the name of employee is ${employee1.name} and age is ${employee1.age} and salary is ${employee1.getSalary()}")
}

fun testCar() {

}