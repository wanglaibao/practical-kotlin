package com.laibao.kotlin.basic.oop.classes

/**
 * 人类
 */
abstract class Human {

    //肤色
    abstract val color:String

    //语言
    abstract val language:String


    abstract fun eat()

    fun sleep() {
        println("该睡觉了啊")
    }


}


/**
 * 中国人
 */

open class Chinese:Human() {

    override val color: String = "黄色"

    override val language: String = "中文"

    override fun eat() {
        println("用筷子吃饭")
    }
}

class American:Human() {

    override val color: String = "白色"

    override val language: String = "英语"

    override fun eat() {
        println("用刀叉吃饭")
    }
}


class African: Human(){
    override val color: String = "黑色"
    override val language: String = "西班牙语"
    override fun eat() {
        println("用手抓")
    }
}


class ZheJiangRen : Chinese(),RideBike,DriveCar {

    override val license:String = "123123123qeqewqeq"

    override fun rideByCycle() {

        println("学会了骑自行车")
    }

    override fun driveBus() {

        println("学会了开车")
    }
}

interface RideBike {

    //骑自行车
    fun rideByCycle()
}

interface DriveCar {

    //kotlin 中接口的属性是无法自行初始化的必须在实现类中进行初始化
    val license:String //= "123123123qeqewqeq"

    //开车
    fun driveBus()
}