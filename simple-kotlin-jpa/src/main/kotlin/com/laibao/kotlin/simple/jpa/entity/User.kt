package com.laibao.kotlin.simple.jpa.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * @author laibao wang
 */

@Entity
data class User (@Id @GeneratedValue(strategy = GenerationType.AUTO)
            val id: Long?,
            val firstName: String?,
            val lastName: String?,
            val gender: String?,
            val age: Int?){

    override fun toString(): String = "People(id=$id, firstName='$firstName', lastName='$lastName', gender='$gender', age=$age)"

}