package com.laibao.kotlin.simple.jpa.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author laibao wang
 */

@RestController
class IndexController {

    @GetMapping(value = *arrayOf("/index", "/"))
    fun index(): String = "Hello,World! this is the index page"

}