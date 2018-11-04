package com.laibao.smart.decision.mapper

import com.laibao.smart.decision.domain.UserArea
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param

@Mapper
interface UserAreaMapper {

    fun deleteByPrimaryKey(id: Long): Int

    fun insert(record: UserArea): Int

    fun insertSelective(record: UserArea): Int

    fun selectByPrimaryKey(id: Long): UserArea

    fun selectUserAreaListByUid(@Param("uid") uid: Long): List<UserArea>

    fun updateByPrimaryKeySelective(record: UserArea): Int

    fun updateByPrimaryKey(record: UserArea): Int
}