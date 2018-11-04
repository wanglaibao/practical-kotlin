package com.laibao.kotlin.springbootkotlin.demo.domain

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * @author laibao wang
 */

@Entity
class Customer (val firstName: String,
                val lastName: String,
                @Id @GeneratedValue
                val id: Long = -1): Serializable{

    /**
     * 添加一个默认的参数为空的构造函数
     */
    //constructor(): this("", "")
}