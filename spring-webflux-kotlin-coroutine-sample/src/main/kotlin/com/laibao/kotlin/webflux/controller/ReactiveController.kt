package com.laibao.kotlin.webflux.controller

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Unconfined
import kotlinx.coroutines.reactor.mono
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class ReactiveController {

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
}