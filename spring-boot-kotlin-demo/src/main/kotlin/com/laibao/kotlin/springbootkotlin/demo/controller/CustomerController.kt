package com.laibao.kotlin.springbootkotlin.demo.controller

import com.laibao.kotlin.springbootkotlin.demo.repository.CustomerRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

/**
 * @author laibao wang
 */
@RestController
class CustomerController (private val customerRepository: CustomerRepository){

    @GetMapping("/customers")
    fun findAll() = customerRepository.findAll()

    @GetMapping("/customers/{lastName}")
    fun findByLastName(@PathVariable lastName:String) = customerRepository.findByLastName(lastName)
}