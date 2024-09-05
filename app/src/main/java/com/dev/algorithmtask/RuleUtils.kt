package com.dev.algorithmtask

fun findOddNumbers(): Set<Int> {
    return (1..100).filter { it % 2 != 0 }.toSet()
}

fun findEvenNumbers(): Set<Int> {
    return (1..100).filter { it % 2 == 0 }.toSet()
}

fun findPrimeNumbers(): Set<Int> {
    return (2..100).filter { isPrime(it) }.toSet()
}

private fun isPrime(num: Int): Boolean {
    if (num <= 1) return false
    for (i in 2 until num) {
        if (num % i == 0) return false
    }
    return true
}

fun findFibonacciNumbers(): Set<Int> {
    val fibonacciNumbers = mutableSetOf<Int>()
    var a = 0
    var b = 1
    while (b <= 100) {
        fibonacciNumbers.add(b)
        val next = a + b
        a = b
        b = next
    }
    return fibonacciNumbers
}