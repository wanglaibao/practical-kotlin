package com.laibao.kotlin.simple.mybatis.service

import com.alibaba.fastjson.JSON
import com.laibao.kotlin.simple.mybatis.domain.User
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

/**
 * @author laibao wang
 */
class UserServiceTest:BaseServiceTest() {

    @Autowired
    private lateinit var userService:UserService

    @Test
    fun testGetUserById() {
        val id:Long = 3
        val user:User = userService.getUserById(id)
        println(JSON.toJSONString(user))
    }

    @Test
    fun testGetAllUsers() {
        val users:List<User> = userService.getAllUser()
        println(JSON.toJSONString(users))
    }
}