package com.laibao.smart.decision.service.impl

import com.laibao.smart.decision.domain.SysCity
import com.laibao.smart.decision.domain.SysDistrict
import com.laibao.smart.decision.domain.UserArea
import com.laibao.smart.decision.mapper.UserAreaMapper
import com.laibao.smart.decision.service.SysCityService
import com.laibao.smart.decision.service.SysDistrictService
import com.laibao.smart.decision.service.SysProvinceService
import com.laibao.smart.decision.service.UserAreaService
import com.laibao.smart.decision.vo.SysCityVO
import com.laibao.smart.decision.vo.SysDistrictVO
import com.laibao.smart.decision.vo.SysProvinceVO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.util.ArrayList

@Service("userAreaService")
class UserAreaServiceImpl (val userAreaMapper: UserAreaMapper): UserAreaService {

//    @Autowired
//    private val userAreaMapper: UserAreaMapper? = null

    @Autowired
    private lateinit var sysProvinceService: SysProvinceService

//    @Autowired
//    private val sysProvinceService: SysProvinceService? = null

    @Autowired
    private lateinit var sysCityService: SysCityService

//    @Autowired
//    private val sysCityService: SysCityService? = null

    @Autowired
    private lateinit var sysDistrictService: SysDistrictService
//    @Autowired
//    private val sysDistrictService: SysDistrictService? = null

    fun selectByPrimaryKey(id: Long): UserArea {
        return userAreaMapper.selectByPrimaryKey(id)
    }

    fun selectUserAreaListByUid(uid: Long): List<UserArea> {
        return userAreaMapper.selectUserAreaListByUid(uid)
    }

    /**
     * 根据provinceId,cityId,districtId获取对应的省市区
     * @param provinceId
     * @param cityId
     * @param districtId
     * @return SysProvinceVO
     */
    suspend fun getAreaByProvinceIdAndCityIdAndDistrictId(provinceId: String, cityId: String, districtId: String): SysProvinceVO {
        val provinceVO = SysProvinceVO()
        val sysProvince = sysProvinceService.selectByPrimaryKey(provinceId)
        //provinceVO.setId(sysProvince.getProvinceId())
        //provinceVO.setName(sysProvince.getProvince())
        provinceVO.id = sysProvince.provinceId
        provinceVO.name = sysProvince.province

        val key: SysCity = SysCity()
        //key.setProvinceId(provinceId)
        //key.setCityId(cityId)
        key.provinceId = provinceId
        key.cityId = cityId

        val sysCity = sysCityService.selectByPrimaryKey(key)
        val cityVOList: MutableList<SysCityVO> = mutableListOf<SysCityVO>()

        val cityVO = SysCityVO()
        cityVO.id = cityId
        cityVO.name = sysCity.city
        //cityVO.setName(sysCity.getCity())

        val districtVOList:MutableList<SysDistrictVO> = mutableListOf<SysDistrictVO>()

        val districtKey = SysDistrict()
        districtKey.cityId = cityId
        districtKey.districtId = districtId
        //districtKey.setCityId(cityId)
        //districtKey.setDistrictId(districtId)

        val sysDistrict = sysDistrictService.selectByPrimaryKey(districtKey)
        val sysDistrictVO = SysDistrictVO()
        sysDistrictVO.id = districtId
        sysDistrictVO.name = sysDistrict.district
        //sysDistrictVO.setId(districtId)
        //sysDistrictVO.setName(sysDistrict.getDistrict())
        districtVOList.add(sysDistrictVO)

        cityVO.child = districtVOList
        //cityVO.setChild(districtVOList)

        cityVOList.add(cityVO)
        provinceVO.child = cityVOList
        //provinceVO.setChild(cityVOList)
        return provinceVO
    }

    /**
     * 根据用户的uid获取用户所管理的所属区域信息
     * @param uid
     * @return UserAreaVO
     */
    /*
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
    */

    override fun selectByPrimaryKey(id: Long?): UserArea {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return UserArea()
    }

    override fun selectUserAreaListByUid(uid: Long?): List<UserArea> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return ArrayList<UserArea>()
    }
}
