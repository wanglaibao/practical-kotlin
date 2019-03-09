package com.laibao.kotlin.designpattern.decorator

fun main() {
    val happy = HappyMap0<String, String>()
    happy["one"] = "one"
    happy["two"] = "two"
    happy["two"] = "three"

    val sadHappy = SadMap(HappyMap<String, String>())
    sadHappy["one"] = "one"
    sadHappy["two"] = "two"
    sadHappy["two"] = "three"
    sadHappy["a"] = "b"
    sadHappy.remove("a")
}

class HappyMap0<K, V>: HashMap<K, V>() {
    override fun put(key: K, value: V): V? {
        return super.put(key, value).apply {
            this?.let {
                println("Yay! $key")
            }
        }
    }
}

class SadMap0<K, V>: HashMap<K, V>() {
    override fun remove(key: K): V? {
        println("Okay...")
        return super.remove(key)
    }
}


class SadMap<K, V> (private val map:MutableMap<K,V> = mutableMapOf()):MutableMap<K,V> by map {
        override fun remove(key: K): V? {
            println("Okay...")
            return map.remove(key).apply { this?.let { println("the key: $key is removed") }
        }
    }
}

class HappyMap<K, V> constructor(private val map: MutableMap<K, V> = mutableMapOf()): MutableMap<K, V> by map {

    override fun put(key: K, value: V): V? {
        return map.put(key, value).apply { this?.let { println("Yay! $key") } }
    }

}

