package com.laibao.kotlin.basic.oop.classes

/**
 * @author laibao wang
 */
class Car constructor(val name:String,val price:Int){

    private var maker:String? = null

    private var miles:Int? = null

    constructor(name:String,price: Int,maker:String):this(name,price){
        this.maker = maker
    }

    constructor(name:String,price: Int,maker: String,miles:Int):this(name,price,maker) {
        this.miles = miles
    }

    fun getMaker():String? = maker

    fun getMiles():Int? = miles
}