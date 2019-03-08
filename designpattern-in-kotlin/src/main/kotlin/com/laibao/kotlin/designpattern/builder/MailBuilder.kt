package com.laibao.kotlin.designpattern.builder

class MailBuilder (val to: String){
    private var mail: Mail = Mail(to)

    fun title(title: String): MailBuilder {
        mail.title = title
        return this
    }

    // Repeated for other properties
    fun message(message:String): MailBuilder {
        mail.message = message
        return this
    }

    fun cc(cc: List<String>):MailBuilder {
        mail.cc = cc
        return this
    }

    fun build(): Mail {
        return mail
    }

}