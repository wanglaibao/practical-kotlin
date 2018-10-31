package com.laibao.kotlin.basic.oop.abstraction

/**
 * @author laibao wang
 */
class American : Human() {
    override val food: String = "汉堡"

    override fun drink() {
        println("美国佬喜欢喝白兰地")
    }
}