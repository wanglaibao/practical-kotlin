package com.laibao.smart.decision.mapper

import com.laibao.smart.decision.domain.SysProvince
import org.apache.ibatis.annotations.Mapper

@Mapper
interface SysProvinceMapper {
    fun deleteByPrimaryKey(provinceId: String): Int

    fun insert(record: SysProvince): Int

    fun insertSelective(record: SysProvince): Int

    fun selectByPrimaryKey(provinceId: String): SysProvince

    fun updateByPrimaryKeySelective(record: SysProvince): Int

    fun updateByPrimaryKey(record: SysProvince): Int
}