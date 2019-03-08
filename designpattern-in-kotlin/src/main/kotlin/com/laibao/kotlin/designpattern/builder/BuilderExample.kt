package com.laibao.kotlin.designpattern.builder

import java.io.File


fun main() {

    val mail0 = Mail("hello").message("How are you?").cc(listOf())

    val mail1 = Mail("hello@mail.com").apply {
        message = "Something"
        title = "Apply"
    }


    val email = MailBuilder(" hello@hello.com ").title("What's up?").build()
    println(email)
}

data class Mail(val to: String,
                var title: String = "",
                var message: String = "",
                var cc: List<String> = listOf(),
                val bcc: List<String> = listOf(),
                val attachments: List<File> = listOf()){

    fun message(msg: String) = apply {
        message = msg
    }

    fun cc(ccList: List<String>) = apply{
        cc = ccList
    }
}