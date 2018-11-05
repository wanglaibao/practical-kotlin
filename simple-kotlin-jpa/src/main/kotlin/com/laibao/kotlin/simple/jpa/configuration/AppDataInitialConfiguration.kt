package com.laibao.kotlin.simple.jpa.configuration

import com.alibaba.fastjson.JSON
import com.laibao.kotlin.simple.jpa.entity.User
import com.laibao.kotlin.simple.jpa.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*

/**
 * @author laibao wang
 */

@Configuration
class AppDataInitialConfiguration {
    private val logger = LoggerFactory.getLogger(AppDataInitialConfiguration::class.java)

    @Bean
    fun init(userService: UserService) = CommandLineRunner {
        userService.save(User(null, "Jason", "Chen", "Male", 28))
        userService.save(User(null, "Bluce", "Li", "Male", 32))
        userService.save(User(null, "Corey", "Chen", "Female", 20))
        userService.save(User(null, "Ge", "Jin", "Male", 28))

        for (user in userService.findAll()!!) {
            logger.info(JSON.toJSONString(user))
        }

        for (lastName in userService.findByLastName("Jin")!!) {
            logger.info(lastName.toString())
        }
    }

}