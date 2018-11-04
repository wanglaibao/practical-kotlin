package com.laibao.smart.decision.vo


import java.util.ArrayList

class SysCityVO {

    var child: List<SysDistrictVO> = ArrayList()

    var id: String? = null

    var name: String? = null

    override fun toString(): String {
        return "SysCityVO{" +
                "child=" + child +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}'
    }
}
