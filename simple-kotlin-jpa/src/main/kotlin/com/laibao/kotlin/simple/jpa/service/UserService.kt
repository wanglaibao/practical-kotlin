package com.laibao.kotlin.simple.jpa.service

import com.laibao.kotlin.simple.jpa.entity.User
import java.util.*

/**
 * @author laibao wang
 */
interface UserService {

    fun findByLastName(lastName: String): List<User>?

    fun <S : User?> save(entity: S): S?

    fun <S : User?> save(entities: MutableIterable<S>?): MutableIterable<S>?

    fun delete(entities: MutableIterable<User>?)

    fun delete(entity: User?)

    fun delete(id: Long?)

    fun findAll(ids: MutableIterable<Long>?): MutableIterable<User>?

    fun findAll(): MutableIterable<User>?

    fun exists(id: Long?): Boolean?

    fun deleteAll()

}