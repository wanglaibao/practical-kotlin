package com.laibao.kotlin.webflux.controller

import com.laibao.kotlin.webflux.domain.User
import com.laibao.kotlin.webflux.service.UserService
import kotlinx.coroutines.*
import kotlinx.coroutines.reactor.flux
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import kotlinx.coroutines.Dispatchers.Unconfined
import kotlinx.coroutines.reactor.mono
import reactor.core.publisher.Mono

/**
 * @author laibao wang
 *
 * spring-webflux-kotlin-coroutine-sample : https://github.com/jkratz55/spring-webflux-kotlin-coroutine-sample
 *
 * kotlin-coroutines-examples : https://github.com/Kotlin/kotlin-coroutines-examples
 *
 * In a Spring Boot WebFlux application we have a number of endpoints (REST and GraphQL) which return a Mono or Flux of something.
 *
 * The code that these endpoints call is all non-blocking, but rather than using reactor we'd like to write all this non-blocking code using Kotlin coroutines.
 *
 * We can use a method such as kotlinx.coroutines.reactor.mono() to wrap our coroutines in a Mono (and the corresponding flux() method for Flux results).
 *
 * In order to call these methods, though, we first need a CoroutineScope to wrap the whole request (and to handle things like cancelling any child coroutines which our main "entry point" coroutine starts).
 *
 * There seem to be several options here.
 *
 * For example, we could construct a new CoroutineScope and choose a dispatcher,
 *
 * e.g. CoroutineScope(Dispatchers.Default).mono {.... Or we could construct our own class which represents the whole HTTP request, and have that implement CoroutineScope, as shown here for an Android Activity.
 *
 * Implicit within this question is the choice of what thread (or thread pool) the work should be executed on. We could create a thread pool ourselves, but Spring Boot WebFlux has already created its own thread pool for handling HTTP requests in a non-blocking environment, so maybe it's better to try to stay in the current thread (or in that thread pool)? If that is the best way to go, is there a way to get at that thread pool and get the coroutine to run on that?
 *
 *
 *
 *
 */



@RestController
class UserController (val userService: UserService){

    // can not used this way, but now 2019-04-30, I still know the reason why
    //lateinit var userService: UserService

    @GetMapping("/all",produces = ["application/stream+json"])
    fun getAllUser() : Mono<List<User>> = CoroutineScope(Unconfined).mono{

        val list:Deferred<List<User>> = async {
            userService.getAllUser()
        }

        list.await()
    }

    @GetMapping("/allUsers",produces = ["application/stream+json"])
    fun getAllUsers() : Flux<User> = CoroutineScope(Unconfined).flux{
        val usersList = userService.getAllUser()
        //val usersList = list.await()
        Flux.fromIterable(usersList)
    }

    @GetMapping("/user/{id}")
    fun getUserById(@PathVariable id : Long) : Mono<User> = CoroutineScope(Unconfined).mono{
        val user:Deferred<User> = async {
            userService.getUserById(id)
        }
        user.await()
    }

    @PostMapping("/user")
    fun addUser(@RequestBody user:User) : List<User> = runBlocking{

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
}