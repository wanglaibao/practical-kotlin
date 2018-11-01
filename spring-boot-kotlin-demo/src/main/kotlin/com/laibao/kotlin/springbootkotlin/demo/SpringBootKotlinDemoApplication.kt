package com.laibao.kotlin.springbootkotlin.demo

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootKotlinDemoApplication {

    private val logger: Logger = LoggerFactory.getLogger(SpringBootKotlinDemoApplication::class.java)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<SpringBootKotlinDemoApplication>(*args)
        }
    }
}


