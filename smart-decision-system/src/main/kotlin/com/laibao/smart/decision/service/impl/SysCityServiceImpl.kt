package com.drong.smart.decision.service.impl

import com.laibao.smart.decision.domain.SysCity
import com.laibao.smart.decision.mapper.SysCityMapper
import com.laibao.smart.decision.service.SysCityService
import org.springframework.stereotype.Service

@Service("sysCityService")
class SysCityServiceImpl (val sysCityMapper: SysCityMapper): SysCityService {

    override fun selectByProvinceId(provinceId: String): List<SysCity> {
        return sysCityMapper.selectByProvinceId(provinceId)
    }

    override fun selectByPrimaryKey(key: SysCity): SysCity {
        return sysCityMapper.selectByPrimaryKey(key)
    }
}
