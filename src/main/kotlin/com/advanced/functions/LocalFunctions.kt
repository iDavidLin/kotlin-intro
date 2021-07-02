package com.advanced.functions

fun foo(fooParam: String) {
    val outerFunction = "Value"

    // local function
    fun bar(barParam: String) {
        println(barParam)
        println(fooParam)
        println(outerFunction)
    }
}

fun login(username: String, password: String) : Boolean {
    var something = 1
    fun validateInput(input: String){
        something++
        if (input.isEmpty()) {
            throw IllegalArgumentException("Must not be empty")
        }
    }
    validateInput(username)
    validateInput(password)
    return true
}

fun main(args: Array<String>) {
    foo("Some value")
}

