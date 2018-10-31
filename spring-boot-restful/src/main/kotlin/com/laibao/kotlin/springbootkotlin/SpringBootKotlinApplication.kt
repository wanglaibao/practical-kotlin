package com.laibao.kotlin.springbootkotlin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootKotlinApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            //SpringApplication.run(SpringBootKotlinApplication::class.java, *args)
            runApplication<SpringBootKotlinApplication>(*args)
        }
    }
}

//fun main(args: Array<String>) {
//    runApplication<SpringBootKotlinApplication>(*args)
//}
