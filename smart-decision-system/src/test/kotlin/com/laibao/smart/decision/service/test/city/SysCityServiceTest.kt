package com.laibao.smart.decision.service.test.city

import com.alibaba.fastjson.JSON
import com.laibao.smart.decision.domain.SysCity
import com.laibao.smart.decision.service.SysCityService
import com.laibao.smart.decision.service.test.BaseServiceTest
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

/**
 * @author laibao wang
 */
class SysCityServicTest:BaseServiceTest() {

    @Autowired
    private lateinit var sysCityService: SysCityService

    @Test
    fun testSelectAllCities() {
        val cityList:List<SysCity> = sysCityService.selectAllCities()
        println(JSON.toJSONString(cityList))
    }

    @Test
    fun testSelectByPrimaryKey() {
        val key = SysCity(cityId = "130600",provinceId = "130000")
        val city = sysCityService.selectByPrimaryKey(key)
        println(JSON.toJSONString(city))
    }

    @Test
    fun testSelectByProvinceId() {
        val provinceId: String = "130000"
        val cityList:List<SysCity> = sysCityService.selectByProvinceId(provinceId)
        println(JSON.toJSONString(cityList))
    }

}