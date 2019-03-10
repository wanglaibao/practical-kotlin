package com.laibao.kotlin.oop.classdefinition

fun main() {
    val player = Player("jinge")
    player.sayHello()
    println("player name is ${player.name} and is ${player.getAge()}")

    val match = Match("金戈","阿拉丁","20190301")

    println(match.getMatchInfo())

}

class Player {
    var name:String = ""

    constructor(fullName:String){
        this.name = fullName
    }

    fun sayHello():Unit {
        println("hello,$name")
    }

    fun getAge():Int {
        return 18
    }
}

class Match(val home:String,val away:String,val date:String) {

    fun getMatchInfo():String {
        return "$away VS $home @ $date"
    }
}