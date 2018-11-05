package com.laibao.smart.decision.service.test.province

import com.alibaba.fastjson.JSON
import com.laibao.smart.decision.service.test.BaseServiceTest
import com.laibao.smart.decision.domain.SysProvince
import com.laibao.smart.decision.service.SysProvinceService
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

/**
 * @author laibao wang
 */
class SysProvinceServiceTest: BaseServiceTest() {

    @Autowired
    private lateinit var sysProvinceService: SysProvinceService

    @Test
    fun testSelectAllProvince() {
        val list:List<SysProvince> = sysProvinceService.selectAllProvince()
        println(JSON.toJSONString(list))
    }

    @Test
    fun testSelectByPrimaryKey() {
        val provinceId: String = "120000"
        val sysProvince:SysProvince = sysProvinceService.selectByPrimaryKey(provinceId)
        println(JSON.toJSONString(sysProvince))
    }
}