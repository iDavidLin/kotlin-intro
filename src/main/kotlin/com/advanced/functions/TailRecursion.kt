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

/**
 * Tail Call optimization is a technique that compilers can perform to essentially convert a function call to a loop. Kotlin allows us to denote certain tail recursive functions to be optimized.
 * Kotlin is not doing this for default
 * */

/**
 * What is tail recursion?
 * How kotlin resolve this question?
 * */

// return a GOTO
// replace a call with a loop?