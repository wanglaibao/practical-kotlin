package com.laibao.smart.decision.domain

import java.io.Serializable

data class UserArea ( var id: Long? = null,
                      var userId: Long? = null,
                      var provinceId: String? = null,
                      var cityId: String? = null,
                      var districtId: String? = null,
                      var status: Byte? = null): Serializable {

}