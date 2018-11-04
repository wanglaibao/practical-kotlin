package com.laibao.smart.decision.domain

import java.io.Serializable

data class SysDistrict (var districtId: String? = null,
                         var cityId: String? = null,
                         var district: String? = null,
                         var state: Byte? = null): Serializable {

}
