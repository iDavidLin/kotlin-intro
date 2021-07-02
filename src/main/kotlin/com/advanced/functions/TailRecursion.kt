package com.advanced.functions

fun factorial(number: Int): Int {
    return when (number) {
        0, 1 -> 1
        else -> number * factorial(number - 1)
    }
}

// Can you make it work?
fun main() {
    println(factorial(1000000))
}
