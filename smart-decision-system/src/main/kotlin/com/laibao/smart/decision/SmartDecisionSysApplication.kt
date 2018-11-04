package com.laibao.smart.decision

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class SmartDecisionSysApplication {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val application = SpringApplication(SmartDecisionSysApplication::class.java)
            application.run(*args)
        }
    }

}
