package com.laibao.kotlin.basic.operator

fun main() {

    //助教
    var zhujiao = Teacher()
    println("助教:  级别 ${zhujiao.level} 薪资 ${zhujiao.salary}")

    //讲师
    var jiangshi = zhujiao++
    println("教师:  级别 ${jiangshi.level} 薪资 ${jiangshi.salary}")

    //副教授
    var fujiaoshou = jiangshi++
    println("副教授:  级别 ${fujiaoshou.level} 薪资 ${fujiaoshou.salary}")

    //教授
    var jiaoshou = fujiaoshou++
    println("教授:  级别 ${jiaoshou.level} 薪资 ${jiaoshou.salary}")
}

class Teacher {
    //级别
    var level = 1

    //薪资
    var salary = 6000


    operator fun inc():Teacher {
        this.level += 1
        this.salary += 1000
        return this
    }
}