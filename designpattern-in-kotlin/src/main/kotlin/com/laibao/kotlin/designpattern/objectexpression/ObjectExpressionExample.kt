package com.laibao.kotlin.designpattern.objectexpression


/**
 * An object expression is equivalent to Java's anonymous class. It is used to instantiate
 * objects that might inherit from some class or implements an interface.
 * A classic use-case is when we need to define objects that are implementing some interface
 *
 * An object expression can also extend classes
 */

fun main() {

    val serviceConnection = object: ServiceConnection {

        override fun onServiceDisconnected(name: String) {
                println("服务断开了 $name")
        }

        override fun onServiceConnected(name: String) {
                println("服务连接上了 $name")
        }
    }
    serviceConnection.onServiceConnected("jinge")
    serviceConnection.onServiceDisconnected("alading")



    val broadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(message: String) {
            println("我已经收到消息了 $message")
        }
    }

    broadcastReceiver.onReceive("杭州市")
    broadcastReceiver.onBroad()
}

interface ServiceConnection {

    fun onServiceDisconnected(name:String)

    fun onServiceConnected(name:String)
}

abstract class BroadcastReceiver {
    abstract fun onReceive(message:String)

    fun onBroad() {
        println("在广播了啊")
    }
}