package com.laibao.kotlin.designpattern.factorymethod

/**
 * The factory pattern is used to replace class constructors,
 * abstracting the process of object generation
 * so that the type of the object instantiated can be determined at run-time.
 */
fun main() {

    val noCurrencyCode = "No Currency Code Available"

    val greeceCode = CurrencyFactory().currencyForCountry(Country.GREECE)?.code ?: noCurrencyCode
    println("Greece currency: $greeceCode")

    val usCode = CurrencyFactory().currencyForCountry(Country.US)?.code ?: noCurrencyCode
    println("US currency: $usCode")

    val ukCode = CurrencyFactory().currencyForCountry(Country.UK)?.code ?: noCurrencyCode
    println("UK currency: $ukCode")
}

interface Currency {
    val code: String
}

enum class Country {
    US, SPAIN, UK, GREECE,CHINA
}

class Euro(override val code: String = "EUR") : Currency

class UsDollar(override val code: String = "USD") : Currency

class ChineseRmb(override val code: String = "RMB") : Currency

class UkPound(override val code: String = "POUND") : Currency

class CurrencyFactory {

    fun currencyForCountry(country: Country): Currency? {
        return when (country) {
            Country.SPAIN, Country.GREECE -> Euro()
            Country.US    -> UsDollar()
            Country.CHINA -> ChineseRmb()
            Country.UK -> UkPound()
        }
    }
}