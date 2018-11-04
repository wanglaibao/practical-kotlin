package com.laibao.smart.decision.vo

import java.util.ArrayList

class SysProvinceVO {

    var child: List<SysCityVO> = ArrayList()

    var id: String? = null

    var name: String? = null

    override fun toString(): String {
        return "SysProvinceVO{" +
                "child=" + child +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}'
    }
}
