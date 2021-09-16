package com.advanced.functions

data class Time(val hours: Int, val mins: Int) {
    operator fun plus(time: Time): Time {
        val minutes = this.mins + time.mins
        val hoursInMinutes = minutes / 60
        val remainingMinutes = minutes % 60
        val hours = this.hours + time.hours + hoursInMinutes
        return Time(hours, remainingMinutes)
    }
}

operator fun StringBuilder.plus(stringBuilder: StringBuilder) {
    stringBuilder.forEach { this.append(it) }
}


fun main(args: Array<String>) {

    val newTime = Time(10, 40) + Time(3, 20)

    println(newTime)
    val newPoint = Point(1, 1) - Point(2, 2)
    println(newPoint)

    val sb = StringBuilder()
    for (str in sb) {
        str + "Value"
    }
}

data class Point(val x: Int, val y: Int)

operator fun Point.plus(point: Point): Point = TODO("please implement this")
operator fun Point.minus(other: Point) = Point(x - other.x, y - other.y)

class Shape {
    private val points = mutableListOf<Point>()

    operator fun Point.unaryPlus() {
        points.add(this)
    }
}

fun shape(init: Shape.() -> Unit): Shape {
    val shape = Shape()
    shape.init()

    return shape
}

val s = shape {
    +Point(0, 0)
    +Point(1, 1)
    +Point(2, 2)
    +Point(3, 4)
}
