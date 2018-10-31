package com.laibao.kotlin.springbootkotlin.controller

import com.laibao.kotlin.springbootkotlin.domain.Greeting
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

/**
 * @author laibao wang
 */

@RestController
class GreetingController {

    private val counter = AtomicLong()

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) = Greeting(counter.incrementAndGet(), "Hello, $name")

}