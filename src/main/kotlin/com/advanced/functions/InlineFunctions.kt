package com.advanced.functions

import java.util.*

inline fun operation(op: () -> Unit) {
    println("Before calling op()")
    op()
    println("After calling op()")
}

fun tryingToInline(op: () -> Unit) {
    val reference = op
    print("Assigned value")
    op()
}

/* fix this
fun <T> List<T>.eachIndexed(f: (Int, T) -> Unit) {
    for (i in indices) {
        f(i, this[i])
    }
}

fun <T> List<T>.indexOf(x: T): Int {
    eachIndexed { index, value ->
        if (value == x) {
            return index
        }
    }

    return -1
}
*/

fun main() {
    operation { println("This is the actual op function")}
    tryingToInline { println("hello") }
}

/**
 * price, every time we call this function, will copy this.
 * */

inline fun nonOp(x: Int) {
    // warning
}

inline fun nonOpf(noinline op:() -> Unit) {
    // warning
}

// optimize the lambda


// if we gonna reference/store the lambda
// then it wouldn't be inline?
/**
 *
fun tryingToInline(op: () -> Unit) {
    val reference = op
    print("Assigned value")
    op()
}
 *
 * */
// can't inline all the functions
// restriction 1. the function is too large; 2. can't reference/store the function
// you can only inline the function just calling the function been pass in.
// if beyound that, you can't inline it


/**
 * Lambdas can be expensive in terms of optimization. However, by using the inline modifier, we can make these calls much more efficient.
 * */

// show kotlin bytecode
// copy the code and paste the code into the place where it use
// which will improve the
// lambda will have a performance issue, in kotlin to minimise this impact, by inline this function
//

// what if we inline the function, what the exception looks like?
// intellij offer choice, you can just jump to the source function

fun <T> Collection<T>.filter(predicate: (T) -> Boolean): Collection<T> = Collections.emptyList()// Omitted
