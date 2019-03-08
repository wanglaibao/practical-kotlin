package com.laibao.kotlin.designpattern.prototype

fun main() {
    val originalPc = PC()
    println()
    val copyPc = originalPc.copy(graphicCard = "nKCF 8999ZTXX", ram = "16GB BBR6")
    println()

    println(originalPc)
    println()
    println(copyPc)
}


data class PC(val motherboard: String = "Terasus XZ27",
              val cpu: String = "Until Atom K500",
              val ram: String = "8GB Microcend BBR5",
              val graphicCard: String = "nKCF 8100TZ")