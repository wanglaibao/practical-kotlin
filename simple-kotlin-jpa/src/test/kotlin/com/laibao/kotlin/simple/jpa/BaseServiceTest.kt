package com.laibao.kotlin.simple.jpa

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(classes = arrayOf(com.laibao.kotlin.simple.jpa.SpringBootKotlinJPAApplication::class))
class BaseServiceTest{

    @Test
    fun contextLoads() {
        println("spring boot application is starting")
    }

}