package com.laibao.smart.decision.domain

import java.io.Serializable

data class SysCity (var cityId: String? = null,
                     var provinceId: String? = null,
                     var city: String? = null,
                     var state: Byte? = null): Serializable {

}