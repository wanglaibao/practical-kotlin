package com.laibao.kotlin.springbootkotlin.demo.repository

import com.laibao.kotlin.springbootkotlin.demo.domain.Customer
import org.springframework.data.repository.CrudRepository

/**
 * @author laibao wang
 */
interface CustomerRepository: CrudRepository<Customer, Long> {
    fun findByLastName(lastName: String): List<Customer>
}