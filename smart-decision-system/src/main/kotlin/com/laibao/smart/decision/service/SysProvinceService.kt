package com.laibao.smart.decision.service

import com.laibao.smart.decision.domain.SysProvince

interface SysProvinceService {

    suspend fun selectByPrimaryKey(provinceId: String): SysProvince

    suspend fun selectAllProvince():List<SysProvince>


    fun selectByPrimaryKeyNoSuspend(provinceId: String): SysProvince

    fun selectAllProvinceNoSuspend():List<SysProvince>
}
