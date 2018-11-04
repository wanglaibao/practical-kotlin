package com.drong.smart.decision.service.impl

import com.drong.smart.decision.bean.vo.*
import com.drong.smart.decision.domain.*
import com.drong.smart.decision.mapper.UserAreaMapper
import com.drong.smart.decision.service.SysCityService
import com.drong.smart.decision.service.SysDistrictService
import com.drong.smart.decision.service.SysProvinceService
import com.drong.smart.decision.service.UserAreaService
import org.apache.commons.collections.CollectionUtils
import org.apache.commons.lang3.StringUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.util.ArrayList

/**
 * @author laibao wang
 * @date 2018-05-22
 * @version 1.0
 */
@Service("userAreaService")
class UserAreaServiceImpl : UserAreaService {

    @Autowired
    private val userAreaMapper: UserAreaMapper? = null

    @Autowired
    private val sysProvinceService: SysProvinceService? = null

    @Autowired
    private val sysCityService: SysCityService? = null

    @Autowired
    private val sysDistrictService: SysDistrictService? = null

    fun selectByExample(example: UserAreaExample): List<UserArea> {
        return userAreaMapper!!.selectByExample(example)
    }

    fun selectByPrimaryKey(id: Long?): UserArea {
        return userAreaMapper!!.selectByPrimaryKey(id)
    }

    fun selectUserAreaListByUid(uid: Long?): List<UserArea> {
        return userAreaMapper!!.selectUserAreaListByUid(uid)
    }

    /**
     * 获取全国所有省市区情况
     * @return List<SysProvinceVO>
    </SysProvinceVO> */
    val allAreaList: List<SysProvinceVO>
        get() {
            val provinceExample = SysProvinceExample()
            val provinceList = sysProvinceService!!.selectByExample(provinceExample)

            val cityExample = SysCityExample()
            val cityList = sysCityService!!.selectByExample(cityExample)

            val districtExample = SysDistrictExample()
            val districtList = sysDistrictService!!.selectByExample(districtExample)

            val provinceVOList = ArrayList()
            for (province in provinceList) {
                val provinceId = province.getProvinceId()
                val provinceName = province.getProvince()
                val provinceVO = SysProvinceVO()
                provinceVO.setId(provinceId)
                provinceVO.setName(provinceName)
                val cityVOList = ArrayList()
                for (city in cityList) {
                    if (city.getProvinceId().equals(provinceId)) {
                        val cityVO = SysCityVO()
                        val cityId = city.getCityId()
                        val cityName = city.getCity()
                        val districtVOList = ArrayList()
                        for (district in districtList) {
                            val districtId = district.getDistrictId()
                            val districtName = district.getDistrict()
                            if (district.getCityId().equals(cityId)) {
                                val sysDistrictVO = SysDistrictVO()
                                sysDistrictVO.setId(districtId)
                                sysDistrictVO.setName(districtName)
                                districtVOList.add(sysDistrictVO)
                            }
                        }
                        cityVO.setId(cityId)
                        cityVO.setName(cityName)
                        cityVO.setChild(districtVOList)
                        cityVOList.add(cityVO)
                    }
                }
                provinceVO.setChild(cityVOList)
                provinceVOList.add(provinceVO)
            }
            return provinceVOList
        }


    /**
     * 根据provinceId获取该省所有市区情况
     * @return SysProvinceVO
     */
    fun getAreaByProvinceId(provinceId: String): SysProvinceVO {
        val sysProvince = sysProvinceService!!.selectByPrimaryKey(provinceId)
        val provinceVO = SysProvinceVO()
        provinceVO.setId(sysProvince.getProvinceId())
        provinceVO.setName(sysProvince.getProvince())
        //城市为空的话取该省下面的所有城市
        val cityList = sysCityService!!.selectByProvinceId(provinceId)
        val cityVOList = ArrayList()
        for (city in cityList) {
            val cityVO = SysCityVO()
            val cityId = city.getCityId()
            val cityName = city.getCity()
            cityVO.setId(cityId)
            cityVO.setName(cityName)
            val districtVOList = ArrayList()
            val sysDistrictList = sysDistrictService!!.selectByCityId(cityId)
            for (district in sysDistrictList) {
                val sysDistrictVO = SysDistrictVO()
                val districtId = district.getDistrictId()
                val districtName = district.getDistrict()
                sysDistrictVO.setId(districtId)
                sysDistrictVO.setName(districtName)
                districtVOList.add(sysDistrictVO)
            }
            cityVO.setChild(districtVOList)
            cityVOList.add(cityVO)
        }
        provinceVO.setChild(cityVOList)
        return provinceVO
    }


    /**
     * 根据provinceId,cityId获取该市所有区情况
     * @param provinceId
     * @param cityId
     * @return SysProvinceVO
     */
    fun getAreaByProvinceIdAndCityId(provinceId: String, cityId: String): SysProvinceVO {
        val provinceVO = SysProvinceVO()
        val sysProvince = sysProvinceService!!.selectByPrimaryKey(provinceId)
        provinceVO.setId(sysProvince.getProvinceId())
        provinceVO.setName(sysProvince.getProvince())

        val key = SysCity()
        key.setProvinceId(provinceId)
        key.setCityId(cityId)
        val city = sysCityService!!.selectByPrimaryKey(key)

        val cityVOList = ArrayList()
        val cityVO = SysCityVO()
        cityVO.setId(cityId)
        cityVO.setName(city.getCity())
        val districtVOList = ArrayList()
        val sysDistrictList = sysDistrictService!!.selectByCityId(cityId)
        for (sysDistrict in sysDistrictList) {
            val sysDistrictVO = SysDistrictVO()
            val districtId = sysDistrict.getDistrictId()
            val districtName = sysDistrict.getDistrict()
            sysDistrictVO.setId(districtId)
            sysDistrictVO.setName(districtName)
            districtVOList.add(sysDistrictVO)
        }
        cityVO.setChild(districtVOList)
        cityVOList.add(cityVO)
        provinceVO.setChild(cityVOList)
        return provinceVO
    }


    /**
     * 根据provinceId,cityId,districtId获取对应的省市区
     * @param provinceId
     * @param cityId
     * @param districtId
     * @return SysProvinceVO
     */
    fun getAreaByProvinceIdAndCityIdAndDistrictId(provinceId: String, cityId: String, districtId: String): SysProvinceVO {
        val provinceVO = SysProvinceVO()
        val sysProvince = sysProvinceService!!.selectByPrimaryKey(provinceId)
        provinceVO.setId(sysProvince.getProvinceId())
        provinceVO.setName(sysProvince.getProvince())

        val key = SysCity()
        key.setProvinceId(provinceId)
        key.setCityId(cityId)
        val sysCity = sysCityService!!.selectByPrimaryKey(key)
        val cityVOList = ArrayList()

        val cityVO = SysCityVO()
        cityVO.setId(cityId)
        cityVO.setName(sysCity.getCity())
        val districtVOList = ArrayList()

        val districtKey = SysDistrict()
        districtKey.setCityId(cityId)
        districtKey.setDistrictId(districtId)

        val sysDistrict = sysDistrictService!!.selectByPrimaryKey(districtKey)
        val sysDistrictVO = SysDistrictVO()
        sysDistrictVO.setId(districtId)
        sysDistrictVO.setName(sysDistrict.getDistrict())
        districtVOList.add(sysDistrictVO)

        cityVO.setChild(districtVOList)

        cityVOList.add(cityVO)
        provinceVO.setChild(cityVOList)
        return provinceVO
    }

    /**
     * 根据用户的uid获取用户所管理的所属区域信息
     * @param uid
     * @return UserAreaVO
     */
    fun getUserUserAreaVOByUid(uid: Long?): UserAreaVO {
        val userAreaList = selectUserAreaListByUid(uid)
        val userAreaVO = UserAreaVO()
        if (CollectionUtils.isEmpty(userAreaList)) {
            return userAreaVO
        }
        val stringBuilder = StringBuilder()
        val caseAreaVOList = ArrayList()
        for (userArea in userAreaList) {
            val caseAreaVO = CaseAreaVO()
            val provinceId = userArea.getProvinceId()
            val cityId = userArea.getCityId()
            val districtId = userArea.getDistrictId()
            if (StringUtils.isBlank(provinceId)) {
                //全国的情况
                return userAreaVO
            }
            val sysProvince = sysProvinceService!!.selectByPrimaryKey(provinceId)
            stringBuilder.append(sysProvince.getProvince())
            caseAreaVO.setProvinceName(sysProvince.getProvince())
            if (StringUtils.isNotBlank(cityId)) {
                val key = SysCity()
                key.setProvinceId(provinceId)
                key.setCityId(cityId)
                val sysCity = sysCityService!!.selectByPrimaryKey(key)
                caseAreaVO.setCityName(sysCity.getCity())
                stringBuilder.append(sysCity.getCity()).append("#")
            } else {
                stringBuilder.append("#")
            }

            if (StringUtils.isNotBlank(districtId)) {
                val districtKey = SysDistrict()
                districtKey.setCityId(cityId)
                districtKey.setDistrictId(districtId)
                val sysDistrict = sysDistrictService!!.selectByPrimaryKey(districtKey)
                caseAreaVO.setDistrictName(sysDistrict.getDistrict())
            }
            caseAreaVOList.add(caseAreaVO)
        }
        userAreaVO.setBankArea(stringBuilder.toString())
        userAreaVO.setCaseAreaVOList(caseAreaVOList)
        return userAreaVO
    }
}
