package com.laibao.kotlin.simple.mybatis.service.impl

import com.laibao.kotlin.simple.mybatis.domain.User
import com.laibao.kotlin.simple.mybatis.mapper.UserMapper
import com.laibao.kotlin.simple.mybatis.service.UserService
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