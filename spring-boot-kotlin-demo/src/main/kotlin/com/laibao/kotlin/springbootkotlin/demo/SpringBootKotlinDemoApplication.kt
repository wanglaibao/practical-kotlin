package com.laibao.kotlin.springbootkotlin.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootKotlinDemoApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<SpringBootKotlinDemoApplication>(*args)
        }
    }
}


