package com.laibao.kotlin.simple.jpa.controller

import com.laibao.kotlin.simple.jpa.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

/**
 * @author laibao
 */
@RestController
class UserController {

    @Autowired
    val userService: UserService? = null

    @GetMapping(value = "/hello")
    fun hello(@RequestParam(value = "lastName") lastName: String): Any {
        val users = userService?.findByLastName(lastName)
        val map = HashMap<Any, Any>()
        map.put("hello", users!!)
        return map
    }

}