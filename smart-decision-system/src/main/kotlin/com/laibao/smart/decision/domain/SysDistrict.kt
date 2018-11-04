package com.laibao.smart.decision.domain

import java.io.Serializable

data class SysDistrict (val districtId: String,
                         val cityId: String,
                         val district: String,
                         val state: Byte): Serializable {

}
