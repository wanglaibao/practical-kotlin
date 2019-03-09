package com.laibao.kotlin.designpattern.objectexpression

/**
 * While object expressions allow us to create objects of an anonymous type
 * that can implement some interface and extend some class,
 * we can use them to easily solve interesting problems related to the Adapter pattern
 *
 *
 * The Adapter design pattern allows otherwise incompatible classes to work together
 * by converting the interface of one class into an interface expected by the clients
 */
fun main() {

    val player = object : Player {
        override fun play() {
            println("让我们一起来玩吧")
        }

        override fun stop() {
            println("玩不了了被停止了")
        }
    }
    playWith(player)



    val playerWithVideo = object: VideoPlayer(), Player {
        override fun stop() {
            println("玩不了了被停止了")
        }
    }

    playWith(playerWithVideo)


    /**
     * We can also define custom methods and properties in the object expression:
     */
    val data = object {
        var size = 1
        fun update() {
            println("更新对象表达式的信息")
        }
    }
    data.size = 2
    data .update()


    /**
     * We can now add a behavior to our VideoPlayer class to fully implement the Player interface
     */
    val playerWithVideoTwo = object: VideoPlayer(), Player {
        var duration:Double = 0.0
        override fun stop() {
            println("Stop video")
        }
    }

    playerWithVideoTwo.play()
    playerWithVideoTwo.stop()
    playerWithVideoTwo.duration = 12.5
}

interface Player {
    fun play()
    fun stop()
}

fun playWith(player: Player) {
    println("I play with")
    println()
    player.play()
}


open class VideoPlayer {
    fun play() {
        println("Play video")
    }
}