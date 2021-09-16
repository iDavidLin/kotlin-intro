package com.advanced.`5 - generics`

open class Mammal(val name: String) {
    fun eat() {}
    fun sleep() {}
}

data class Sloths(val slothName: String, val isTwoFingered: Boolean): Mammal(slothName)

data class Pandas(val pandaName: String) : Mammal(pandaName)

fun feedCrew(crew: List<Mammal>) { // List<out E> is covariant on its element type
    crew.forEach {
        it.eat()
    }
}

fun main () {
    val slothCrew = listOf(
            Sloths("Jerry", false),
            Sloths("Bae", true),
            Sloths("Chrissy", false),
    )

    val pandaCrew = listOf(
            Pandas("Jay"),
            Pandas("Peggy")
    )

    val crewCrewCrew = listOf(
            Sloths("Jerry", false),
            Sloths("Bae", true),
            Sloths("Alex", false),
            Pandas("Tegan"),
            Pandas("Peggy")
    )

    feedCrew(slothCrew)
    feedCrew(pandaCrew)

    feedCrew(crewCrewCrew)
}

// List is covariance
// covariance: out
// Contravariance: in
// out: declaration-site, benefits we only need to declare it once, not every time we call it

// covariance: values area passed out


// contravariance: values are passed in
// declaration-site to indicate contravariance
// via in modifier
// similar to ?super T in Java
interface WriteRepo<T> {
    fun save(obj: T)
    fun saveAll(list: List<T>)
}

interface ReadOnlyRepo<T> {
    fun getId(id: Int): T
    fun getAll(): List<T>
}

interface Group<T> {
    fun insert(item: T): Unit
    fun fetch(): T
}

