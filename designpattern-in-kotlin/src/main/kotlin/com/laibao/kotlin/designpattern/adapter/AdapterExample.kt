package com.laibao.kotlin.designpattern.adapter

import java.util.stream.Stream
import kotlin.streams.toList

fun main() {
    cellPhone(
            charger(
                    powerOutlet().toEUPlug()
            ).toUsbTypeC()
    )

    val strList = listOf("a", "b", "c")

    streamProcessing(strList.stream())

    val intStream = Stream.generate { 42 }.limit(100)
    collectionProcessing(intStream.toList())
}

fun <T> streamProcessing(stream: Stream<T>) {
    stream.forEach(::println)
}

fun <T> collectionProcessing(c: Collection<T>) {
    for (e in c) {
        println(e)
    }
}

interface UsbTypeC

interface UsbMini

interface EUPlug

interface USPlug


fun powerOutlet() : USPlug {
    return object : USPlug {

    }
}

fun cellPhone(chargeCable: UsbTypeC) {

}

// Charger accepts EUPlug interface and exposes UsbMini interface
fun charger(plug: EUPlug) : UsbMini {
    return object : UsbMini {

    }
}



fun USPlug.toEUPlug() : EUPlug {
    return object : EUPlug {
        // Do something to convert
    }
}


fun UsbMini.toUsbTypeC() : UsbTypeC {
    return object : UsbTypeC {
        // Do something to convert
    }
}