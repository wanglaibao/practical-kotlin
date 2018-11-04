package com.laibao.kotlin.simple.mybatis.mapper

import com.laibao.kotlin.simple.mybatis.domain.User
import org.apache.ibatis.annotations.*

/**
 * @author laibao wang
 */
@Mapper
interface UserMapper {
    fun queryAllUser(): List<User>

    fun queryUserById(@Param("id") id : Long?): User

    fun saveUser(user:User):Unit

    fun updateUser(user: User):Unit

    fun deleteUserById(@Param("id") id: Long?):Unit
}