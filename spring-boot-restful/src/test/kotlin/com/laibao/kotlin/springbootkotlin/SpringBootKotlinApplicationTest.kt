package com.laibao.kotlin.springbootkotlin

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class SpringBootKotlinApplicationTest {

	@Test
	fun contextLoads() {
		println("系统初始化正常啦!!!")
	}

}
