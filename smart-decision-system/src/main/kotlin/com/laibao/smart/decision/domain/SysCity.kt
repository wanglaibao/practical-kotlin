package com.laibao.smart.decision.domain

import java.io.Serializable

data class SysCity (val cityId: String,
                     val provinceId: String,
                     val city: String,
                     val state: Byte): Serializable {

}