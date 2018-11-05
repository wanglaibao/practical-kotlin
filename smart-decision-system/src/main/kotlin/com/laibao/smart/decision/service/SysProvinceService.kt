package com.laibao.smart.decision.service

import com.laibao.smart.decision.domain.SysProvince

interface SysProvinceService {

    fun selectByPrimaryKey(provinceId: String): SysProvince

    fun selectAllProvince():List<SysProvince>
}
