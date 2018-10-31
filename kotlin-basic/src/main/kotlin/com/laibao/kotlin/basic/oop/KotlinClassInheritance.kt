package com.laibao.kotlin.basic.oop

import com.laibao.kotlin.basic.oop.inheritance.Person
import com.laibao.kotlin.basic.oop.inheritance.Student
import com.laibao.kotlin.basic.oop.inheritance.Teacher

/**
 * @author laibao wang
 */

/**
 *  Syntax – Kotlin Inheritance
 *  Following is the syntax to declare a class to inherit another class in Kotlin.
 *               在中类默认是Final类型的，所以要能够继承的话必须使用open关键子
 *              open class ParentClass(primary_constructor){
 *                       // common behaviour
 *               }
 *
 *               class ChildClass(primary_constructor): ParentClass(primary_constructor_initialization){
 *                       // ChildClass specific behaviours
 *               }
 */
fun main(args: Array<String>) {
    val person = Person()
    println("name is ${person.name} and role is ${person.role}")
    person.eat()
    person.sleep()
    person.love()
    person.marry()

    val student = Student("王五")
    println("name is ${student.name} and role is ${student.role}")
    student.eat()
    student.sleep()
    student.love()
    student.doActivity()
    student.doAll()
    student.marry()

    val teacher = Teacher("汪老师")
    println("name is ${teacher.name} and role is ${teacher.role}")
    teacher.eat()
    teacher.sleep()
    teacher.love()
    teacher.doProfession()
    teacher.doAll()
    teacher.marry()
}
