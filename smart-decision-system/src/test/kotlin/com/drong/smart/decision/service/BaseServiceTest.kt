package com.drong.smart.decision.service

import com.laibao.smart.decision.SmartDecisionSysApplication
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(classes = arrayOf(SmartDecisionSysApplication::class))
class BaseServiceTest {

    @Test
    fun contextLoads() {
        println("spring boot smart desicion system application is starting")
    }

}
