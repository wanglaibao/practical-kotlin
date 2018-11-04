package com.laibao.kotlin.simple.mybatis.service
import com.laibao.kotlin.simple.mybatis.domain.User

/**
 * @author laibao wang
 */
interface UserService {
    fun getAllUser(): List<User>

    fun getUserById(id : Long?): User

    fun insertUser(user: User):Unit

    fun modifyUser(user: User):Unit

    fun removeUserById(id: Long?):Unit
}