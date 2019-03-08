package com.laibao.kotlin.designpattern.factorymethod

fun main() {
    val animalTypes = listOf("dog", "dog", "cat", "dog", "cat", "cat")
    for (t in animalTypes) {
        val c = animalFactory(t)
        println(c.name)
    }

    println()
    println()


    val factory = AnimalFactory()
    for (t in animalTypes) {
        val c = factory.createAnimal(t)
        println("${c.id} - ${c.name}")
    }
    println()
    println()

    val anotherAnimalTypes = listOf("dog" to "bulldog", "dog" to "beagle", "cat" to "persian",
                                     "dog" to "poodle", "cat" to "russian blue", "cat" to "siamese")


    for ((type, breed) in anotherAnimalTypes) {
        val c = factory.createAnimal(type, breed)
        println(c.name)
    }
}

interface Animal {
    val id : Int
    val name : String
}

class Cat(override val id: Int):Animal {
    override val name = "Cat"

    constructor():this(0)
}

open class Dog(override val id: Int):Animal{
    override val name = "Dog"

    constructor():this(0)
}

class Beagle(id: Int) : Dog(id)

class Bulldog(id: Int) : Dog(id)

class AnimalFactory {
    var counter = 0

    private val dogFactory = DogFactory()
    private val catFactory = CatFactory()

    fun createAnimal(animalType: String) : Animal {
        return when(animalType.trim().toLowerCase()) {
            "cat" -> Cat(++counter)
            "dog" -> Dog(++counter)
            else -> throw RuntimeException("Unknown animal $animalType")
        }
    }

    fun createAnimal(animalType: String, animalBreed: String) : Animal {
        return when(animalType.trim().toLowerCase()) {
            "cat" -> catFactory.createCat(animalBreed, ++counter)
            "dog" -> dogFactory.createDog(animalBreed, ++counter)
            else -> throw RuntimeException("Unknown animal $animalType")
        }
    }
}


class DogFactory {

    fun createDog(breed: String, id: Int):Animal = when(breed.trim().toLowerCase()) {
        "beagle" -> Beagle(id)
        "bulldog" -> Bulldog(id)
        else -> throw RuntimeException("Unknown dog breed $breed")
    }

}

class CatFactory {
    fun createCat(breed: String, i: Int): Animal {
        return Cat(i)
    }
}

fun animalFactory(animalType: String) : Animal {
    return when(animalType.toLowerCase()) {
        "cat" -> Cat()
        "dog" -> Dog()
        else -> throw RuntimeException("Unknown animal $animalType")
    }
}

