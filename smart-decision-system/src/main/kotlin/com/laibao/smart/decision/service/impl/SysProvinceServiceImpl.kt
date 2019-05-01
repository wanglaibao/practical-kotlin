package com.laibao.smart.decision.service.impl

import com.laibao.smart.decision.domain.SysProvince
import com.laibao.smart.decision.mapper.SysProvinceMapper
import com.laibao.smart.decision.service.SysProvinceService
import org.springframework.stereotype.Service

@Service("sysProvinceService")
class SysProvinceServiceImpl (val sysProvinceMapper: SysProvinceMapper): SysProvinceService {

    override suspend fun selectByPrimaryKey(provinceId: String): SysProvince {
        return sysProvinceMapper.selectByPrimaryKey(provinceId)
    }

    override suspend fun selectAllProvince(): List<SysProvince> {
        return sysProvinceMapper.selectAllProvince()
    }

    override fun selectByPrimaryKeyNoSuspend(provinceId: String): SysProvince {
        return sysProvinceMapper.selectByPrimaryKey(provinceId)
    }

    override fun selectAllProvinceNoSuspend(): List<SysProvince> {
        return sysProvinceMapper.selectAllProvince()
    }
}
