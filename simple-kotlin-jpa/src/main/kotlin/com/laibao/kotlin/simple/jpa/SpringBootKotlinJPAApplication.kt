package com.laibao.kotlin.simple.jpa

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootKotlinJPAApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<SpringBootKotlinJPAApplication>(*args)
        }
    }
}