package com.laibao.kotlin.springbootkotlin.demo

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForObject
import org.springframework.test.context.junit4.SpringRunner
import kotlin.test.assertEquals

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootKotlinDemoApplicationTest{

    @Autowired
	private lateinit var restTemplate: TestRestTemplate

	@Test
	fun contextLoads() {
        println("系统初始化正常啦!!!")
	}

    @Test
    fun findAll() {
        val content = """[{"firstName":"Jack","lastName":"Bauer","id":1},{"firstName":"Chloe","lastName":"O'Brian","id":2},{"firstName":"Kim","lastName":"Bauer","id":3},{"firstName":"David","lastName":"Palmer","id":4},{"firstName":"Michelle","lastName":"Dessler","id":5}]"""
        assertEquals(content, restTemplate.getForObject<String>("/customers"))
    }
}
