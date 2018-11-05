package com.laibao.kotlin.simple.jpa.service.impl

import com.laibao.kotlin.simple.jpa.entity.User
import com.laibao.kotlin.simple.jpa.repository.UserRepository
import com.laibao.kotlin.simple.jpa.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @author laibao wang
 */
@Service("userService")
class UserServiceImpl: UserService {

    @Autowired
    val userRepository: UserRepository? = null

    override fun findByLastName(lastName: String): List<User>? = userRepository?.findByLastName(lastName)

    override fun <S : User?> save(entity: S): S? {
        return userRepository?.save(entity)
    }

    override fun <S : User?> save(entities: MutableIterable<S>?): MutableIterable<S>? {
        return userRepository?.saveAll(entities)
    }

    override fun delete(entities: MutableIterable<User>?) {
        userRepository?.deleteAll(entities)
    }

    override fun delete(entity: User?) {
        userRepository?.delete(entity)
    }

    override fun delete(id: Long?) {
        userRepository?.deleteById(id)
    }

    override fun findAll(ids: MutableIterable<Long>?): MutableIterable<User>? =  userRepository?.findAllById(ids)

    override fun findAll(): MutableIterable<User>? = userRepository?.findAll()


    override fun exists(id: Long?): Boolean? {
        return userRepository?.existsById(id)
    }

    override fun deleteAll() {
        userRepository?.deleteAll()
    }
}