package com.laibao.smart.decision.mapper

import com.laibao.smart.decision.domain.SysDistrict
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param

@Mapper
interface SysDistrictMapper {

    fun deleteByPrimaryKey(key: SysDistrict): Int

    fun insert(record: SysDistrict): Int

    fun insertSelective(record: SysDistrict): Int


    fun selectByCityId(@Param("cityId") cityId: String): List<SysDistrict>

    fun selectByPrimaryKey(key: SysDistrict): SysDistrict

    fun updateByPrimaryKeySelective(record: SysDistrict): Int

    fun updateByPrimaryKey(record: SysDistrict): Int
}