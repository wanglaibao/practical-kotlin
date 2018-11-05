package com.laibao.kotlin.simple.jpa.repository

import com.laibao.kotlin.simple.jpa.entity.User
import org.springframework.data.repository.CrudRepository

/**
 * @author laibao wang
 */
interface UserRepository : CrudRepository<User, Long> {
    fun findByLastName(lastName: String): List<User>?
}