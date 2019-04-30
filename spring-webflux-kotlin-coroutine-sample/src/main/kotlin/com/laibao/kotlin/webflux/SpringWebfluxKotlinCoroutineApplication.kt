package com.laibao.kotlin.webflux

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringWebfluxKotlinCoroutineApplication {

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<SpringWebfluxKotlinCoroutineApplication>(*args)
        }
    }
}