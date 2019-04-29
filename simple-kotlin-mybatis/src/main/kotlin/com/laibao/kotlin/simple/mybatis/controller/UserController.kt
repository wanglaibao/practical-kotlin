package com.laibao.kotlin.simple.mybatis.controller

import com.laibao.kotlin.simple.mybatis.domain.User
import com.laibao.kotlin.simple.mybatis.service.UserService
import kotlinx.coroutines.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * @author laibao wang
 */
@RestController
class UserController (){

//    @Autowired
//    lateinit var userMapper: UserMapper

    @Autowired
    private lateinit var userService: UserService

    @GetMapping("/all")
    fun getAllUser() : List<User> = runBlocking{

        async { testMethod1() }
        async { testMethod2() }
        async { testMethod3() }

        async{
            //测试通过了
            val userList: List<User> = userService.getAllUser()
            userList
        }.await()
    }

    @GetMapping("/user/{id}")
    fun getUserById(@PathVariable id : Long) : User = runBlocking{

        async { testMethod1() }
        async { testMethod2() }
        async { testMethod3() }

        async{
            //测试通过了
            val user:User = userService.getUserById(id)
            //return user
            user
        }.await()
    }

    @PostMapping("/user")
    fun addUser(@RequestBody user:User) : List<User> = runBlocking{

        async { testMethod1() }
        async { testMethod2() }
        async { testMethod3() }

        async{
            //测试通过了
            userService.insertUser(user)
            //return getAllUser()
            userService.getAllUser()
        }.await()
    }

    @PutMapping("/user")
    fun updateUserById(@RequestBody user: User) : List<User> = runBlocking{

        async{
            //测试通过了
            userService.modifyUser(user)
            //return getAllUser()
            userService.getAllUser()
        }.await()
    }

    @DeleteMapping("user")
    fun removeUserById(@RequestBody user:User) : List<User> = runBlocking{

        async{
            userService.removeUserById(user.id)
            userService.getAllUser()
        }.await()
    }

    private suspend fun testMethod1() {
       delay(1000)
    }

    private suspend fun testMethod2() {
        delay(2000)
    }

    private suspend fun testMethod3() {
        delay(3000)
    }
}