package com.laibao.kotlin.simple.mybatis.service.user

import com.alibaba.fastjson.JSON
import com.laibao.kotlin.simple.mybatis.domain.User
import com.laibao.kotlin.simple.mybatis.service.BaseServiceTest
import com.laibao.kotlin.simple.mybatis.service.UserService
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

/**
 * @author laibao wang
 */
class UserServiceTest: BaseServiceTest() {

    @Autowired
    private lateinit var userService: UserService

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

    @Test
    fun testInsertUser() {
        val user: User = User(name = "阿里巴巴")
        userService.insertUser(user)
    }

    @Test
    fun testUpdateUser() {
        val user: User = User(10,"金砖五国")
        userService.modifyUser(user)
    }

    @Test
    fun testDeleteUserById() {
        val id: Long = 10
        userService.removeUserById(id)
    }
}