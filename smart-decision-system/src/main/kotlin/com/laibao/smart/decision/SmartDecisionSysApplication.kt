package com.laibao.smart.decision

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class SmartDecisionSysApplication {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(SmartDecisionSysApplication::class.java, *args)
        }
    }

}
