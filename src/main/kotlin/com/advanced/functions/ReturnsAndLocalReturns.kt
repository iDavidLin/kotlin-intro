package com.advanced.functions

fun containingFunction() {
    val numbers = 1..100

    numbers.forEach{
        if (it % 5 == 0) {
            return
        }
    }
    println("Hello!")
}

// Can you make the print the hello but not removing the return
fun main() {
    containingFunction()
}