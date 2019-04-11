package com.laibao.kotlin.basic.lazyinit

fun main() {


    /**
     * by lazy 可以用于修饰成员变量,用于成员变量的延迟初始化
     * by lazy 可以用于修饰top level val 变量,用于top level val变量的延迟初始化
     * by lazy 的返回值是代码块中的最后一行
     * by lazy 是线程安全的
     *
     * lateinit var 用于修饰成员变量  表示延时初始化，在使用的时候先进行初始化 再使用
     */
    val name:String  by lazy{
        println("打印测试，看看这个延迟初始化是否真的就执行了一次，而且是在第一次调用的时候进行的，后续调用就没有初始化了")
        "金戈"
    }

    lateinit var passWord:String

    for (element in 1 .. 10) {
        println("the name is $name")
    }

    fun setPassWord(pass:String) {
        passWord = pass
    }


    /**
     * by lazy, lateinit 都可以放在类中或者单独使用
     * by lazy 知道具体的值，使用的时候再【加载】初始化，而且只是初始化一次
     * lateinit 不知道具体的值，使用的时候再赋值
     * by lazy 只能用于val变量 lateinit 只能用于 var 变量
     */
}

