package com.drong.smart.decision.service.impl

import com.laibao.smart.decision.domain.SysDistrict
import com.laibao.smart.decision.mapper.SysDistrictMapper
import com.laibao.smart.decision.service.SysDistrictService
import org.springframework.stereotype.Service

@Service("sysDistrictService")
class SysDistrictServiceImpl (val sysDistrictMapper: SysDistrictMapper): SysDistrictService {

    override fun selectByCityId(cityId: String): List<SysDistrict> {
        return sysDistrictMapper.selectByCityId(cityId)
    }

    override fun selectByPrimaryKey(key: SysDistrict): SysDistrict {
        return sysDistrictMapper.selectByPrimaryKey(key)
    }
}
