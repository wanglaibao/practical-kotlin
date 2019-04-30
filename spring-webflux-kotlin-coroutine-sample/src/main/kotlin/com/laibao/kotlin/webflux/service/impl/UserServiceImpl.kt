package com.laibao.kotlin.webflux.service.impl

import com.laibao.kotlin.webflux.mapper.UserMapper
import com.laibao.kotlin.webflux.domain.User
import com.laibao.kotlin.webflux.service.UserService
import org.springframework.stereotype.Service

/**
 * @author laibao wang
 */
@Service("userService")
class UserServiceImpl(private val userMapper: UserMapper) : UserService {

    override fun getAllUser(): List<User> = userMapper.queryAllUser()


    override fun getUserById(id: Long?): User = userMapper.queryUserById(id)


    override fun insertUser(user: User):Unit {
        userMapper.saveUser(user)
    }

    override fun modifyUser(user: User) {
        userMapper.updateUser(user)
    }

    override fun removeUserById(id: Long?) {
        userMapper.deleteUserById(id)
    }
}