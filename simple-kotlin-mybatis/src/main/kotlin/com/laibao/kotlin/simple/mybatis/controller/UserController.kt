package com.laibao.kotlin.simple.mybatis.controller

import com.laibao.kotlin.simple.mybatis.domain.User
import com.laibao.kotlin.simple.mybatis.mapper.UserMapper
import com.laibao.kotlin.simple.mybatis.service.UserService
import org.apache.ibatis.annotations.Param
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * @author laibao wang
 */
@RestController
class UserController {

//    @Autowired
//    lateinit var userMapper: UserMapper

    @Autowired
    private lateinit var userService: UserService

    @GetMapping("/all")
    fun getAllUser() : List<User> {
        //测试通过了
        val userList: List<User> = userService.getAllUser()
        return userList
    }

    @GetMapping("/user/{id}")
    fun getUserById(@PathVariable id : Long) : User {
        //测试通过了
        val user:User = userService.getUserById(id)
        return user
    }

    @PostMapping("/user")
    fun addUser(@RequestBody user:User) : List<User> {
        //测试通过了
        userService.insertUser(user)
        return getAllUser()
    }

    @PutMapping("/user")
    fun updateUserById(@RequestBody user: User) : List<User> {
        //测试通过了
        userService.modifyUser(user)
        return getAllUser()
    }

    @DeleteMapping("user")
    fun removeUserById(@RequestBody user:User) : List<User> {
        userService.removeUserById(user.id)
        return getAllUser()
    }

}