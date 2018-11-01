package com.laibao.kotlin.springbootkotlin.demo.configuration

import com.laibao.kotlin.springbootkotlin.demo.domain.Customer
import com.laibao.kotlin.springbootkotlin.demo.repository.CustomerRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @author laibao wang
 */

@Configuration
class AppDataInitConfiguration {
    private val logger = LoggerFactory.getLogger(AppDataInitConfiguration::class.java)

    @Bean
    fun init(repository: CustomerRepository) = CommandLineRunner {
        // save a couple of customers
        repository.save(Customer("Jack", "Bauer"))
        repository.save(Customer("Chloe", "O'Brian"))
        repository.save(Customer("Kim", "Bauer"))
        repository.save(Customer("David", "Palmer"))
        repository.save(Customer("Michelle", "Dessler"))

        // fetch all customers
        logger.info("Customers found with findAll():")
        logger.info("-------------------------------")
        repository.findAll().forEach { logger.info(it.toString()) }
        logger.info("")

        // fetch an individual customer by ID
        val customer = repository.findById(1L)
        customer.ifPresent {
            logger.info("Customer found with findById(1L):")
            logger.info("--------------------------------")
            logger.info(it.toString())
            logger.info("")
        }

        // fetch customers by last name
        logger.info("Customer found with findByLastName('Bauer'):")
        logger.info("--------------------------------------------")
        repository.findByLastName("Bauer").forEach { logger.info(it.toString()) }
        logger.info("")
    }
}