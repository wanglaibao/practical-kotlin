package com.laibao.smart.decision.domain

import java.io.Serializable

data class UserArea ( val id: Long,
                      val userId: Long,
                      val provinceId: String,
                      val cityId: String,
                      val districtId: String,
                      val status: Byte): Serializable {

}