package com.laibao.kotlin.basic.delegation

fun main() {

    val bigHeadSon = BigHeadSon()
    val smallHeadFather = SmallHeadFather()

    bigHeadSon.wash()
    smallHeadFather.wash()

    val littleHeadFather = LittleHeadFather(bigHeadSon)
    littleHeadFather.wash()
}

interface WashPower{

    fun wash()
}

class BigHeadSon:WashPower{

    override fun wash() {
        println("大头儿子在洗碗了啊")
    }
}


class SmallHeadFather:WashPower by BigHeadSon()


class LittleHeadFather(washPower: WashPower):WashPower by washPower