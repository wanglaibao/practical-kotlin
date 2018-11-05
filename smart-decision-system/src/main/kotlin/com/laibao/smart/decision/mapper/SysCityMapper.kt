package com.laibao.smart.decision.mapper

import com.laibao.smart.decision.domain.SysCity
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param

@Mapper
interface SysCityMapper {
    fun deleteByPrimaryKey(key: SysCity): Int

    fun insert(record: SysCity): Int

    fun insertSelective(record: SysCity): Int

    fun selectByProvinceId(@Param("provinceId") provinceId: String): List<SysCity>

    fun selectByPrimaryKey(key: SysCity): SysCity

    fun updateByPrimaryKeySelective(record: SysCity): Int

    fun updateByPrimaryKey(record: SysCity): Int

    fun selectAllCities(): List<SysCity>
}