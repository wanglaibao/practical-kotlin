package com.laibao.smart.decision.service

import com.laibao.smart.decision.domain.SysDistrict
import org.apache.ibatis.annotations.Param

interface SysDistrictService {

    fun selectByCityId(@Param("cityId") cityId: String): List<SysDistrict>

    fun selectByPrimaryKey(key: SysDistrict): SysDistrict
}
