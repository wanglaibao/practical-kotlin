package com.laibao.kotlin.webflux.controller

import com.laibao.kotlin.webflux.domain.User
import com.laibao.kotlin.webflux.service.UserService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Unconfined
import kotlinx.coroutines.reactor.mono
import org.reactivestreams.Publisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.util.function.Tuples

@RestController
class ReactiveController {

    @Autowired
    lateinit var userService: UserService

    @GetMapping("/reactiveCoroutine")
    fun getMessages(): Mono<String> = CoroutineScope(Unconfined).mono {

        //val users = userRepository.findAll().awaitFirst()
        //val messages = messageRepository.findAll().awaitFirst()
        //messages
        "我是金戈"
    }

    @GetMapping("/reactive")
    fun getMessagesReactive(): Flux<String> {
        //        return userRepository.findAll()
        //                .next()
        //                .flatMapMany { u ->
        //                    messageRepository.findAll()
        //                }

        val list:List<String> = listOf("aaaa","bbbbb","cccccccc")

        return Flux.fromIterable(list)

    }



    @GetMapping("/reactive/allUsers",produces = ["application/stream+json"])
    fun getReactiveAllUsers() : Flux<User>{
       return Flux.fromIterable(userService.getAllUser())
    }


    @GetMapping("/fibonacci",produces = ["application/stream+json"])
    fun getFibonacciSeries(): Flux<Long> {

        return Flux.generate({ Tuples.of(0L, 1L) },
                { state, sink ->
                    if (state.t1 < 0) {
                        sink.complete()
                    } else {
                        sink.next(state.t1)
                    }
                    Tuples.of(state.t2, state.t1 + state.t2)
                })
    }

    @GetMapping("/fibonacci1",produces = ["text/event-stream"])
    fun getFibonacciSeries1(): Flux<Long> {

        return Flux.generate({ Tuples.of(0L, 1L) },
                { state, sink ->
                    if (state.t1 < 0) {
                        sink.complete()
                    } else {
                        sink.next(state.t1)
                    }
                    Tuples.of(state.t2, state.t1 + state.t2)
                })
    }


    @GetMapping("/hello")
    fun handle(): String {
        return "Hello WebFlux"
    }

    //以流的形式输出
    @GetMapping("/helloStream", produces = ["text/event-stream"])
    fun handler(): Flux<String> {
        return Flux.just("Hello world!", "This is from webflux")
    }

    //以流的形式输出
    @GetMapping("/helloStream1", produces = ["application/stream+json"])
    fun handler1(): Flux<String> {
        return Flux.just("Hello world!", "This is from webflux")
    }

}