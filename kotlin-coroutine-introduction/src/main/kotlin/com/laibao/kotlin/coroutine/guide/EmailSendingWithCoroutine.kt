package com.laibao.kotlin.coroutine.guide

import kotlinx.coroutines.*

fun main() = runBlocking { //(1)
    val job = GlobalScope.launch {
        sendEmailSuspending() //(2)
        println("Email sent successfully.")
    }
    job.join() //(9)
    println("Finished")
}


suspend fun sendEmail(r: String, msg: String): Boolean { //(6)
    delay(2000)
    println("Sent '$msg' to $r")
    return true
}

suspend fun getReceiverAddressFromDatabase(): String { //(4)
    delay(1000)
    return "coroutine@kotlin.org"
}

suspend fun sendEmailSuspending(): Boolean {
    val msg = GlobalScope.async { //(3)
        delay(500)
        "The message content"
    }

    val recipient = GlobalScope.async {
        getReceiverAddressFromDatabase() //(5)
    }

    println("Waiting for email data")

    val sendStatus = GlobalScope.async {
        sendEmail(recipient.await(), msg.await()) //(7)
    }

    return sendStatus.await() //(8)
}