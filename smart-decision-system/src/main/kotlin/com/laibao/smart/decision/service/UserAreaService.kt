package com.laibao.smart.decision.service

import com.laibao.smart.decision.domain.UserArea

interface UserAreaService {

    fun selectByPrimaryKey(id: Long?): UserArea

    fun selectUserAreaListByUid(uid: Long?): List<UserArea>
}
