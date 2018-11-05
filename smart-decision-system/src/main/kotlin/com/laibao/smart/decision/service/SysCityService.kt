package com.laibao.smart.decision.service

import com.laibao.smart.decision.domain.SysCity

interface SysCityService {

    fun selectByProvinceId(provinceId: String): List<SysCity>

    fun selectByPrimaryKey(key: SysCity): SysCity

    fun selectAllCities(): List<SysCity>
}
