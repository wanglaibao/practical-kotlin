package com.laibao.kotlin.oop.interfacedefinition

fun main() {
    val oracle = OracleDataBase("oracle数据库连接字符串")
    println(oracle.dataBaseName)
    println(oracle.connectString)
    oracle.showInfo()
    oracle.connect()
    oracle.close()
}

interface IDataBase {
    fun connect()

    fun close()
}


abstract class DataBase(dataBaseName:String):IDataBase {
    val dataBaseName:String = dataBaseName

    var connectString = ""

    fun showInfo() {
        println("数据库是 $dataBaseName")
    }
}


class OracleDataBase(connectString:String):DataBase("oracle") {
    init {
        super.connectString = connectString
    }

    override fun connect() {
        println("$dataBaseName 连接......($connectString)")
    }

    override fun close() {
        println("$dataBaseName 关闭")
    }
}
