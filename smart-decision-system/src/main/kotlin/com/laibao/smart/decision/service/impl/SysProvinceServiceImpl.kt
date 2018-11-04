package com.drong.smart.decision.service.impl

import com.laibao.smart.decision.domain.SysProvince
import com.laibao.smart.decision.mapper.SysProvinceMapper
import com.laibao.smart.decision.service.SysProvinceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service("sysProvinceService")
class SysProvinceServiceImpl (val sysProvinceMapper: SysProvinceMapper): SysProvinceService {

    override fun selectByPrimaryKey(provinceId: String): SysProvince {
        return sysProvinceMapper.selectByPrimaryKey(provinceId)
    }

}
