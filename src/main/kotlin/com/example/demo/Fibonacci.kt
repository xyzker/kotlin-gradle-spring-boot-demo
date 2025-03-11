package com.example.demo


fun fibonacci(): Sequence<Int> = sequence {
    var a = 0
    var b = 1
    yield(a)
    yield(b)
    while (true) {
        val next = a + b
        a = b
        b = next
        yield(next)
    }
}

fun main(args: Array<String>) {
    fibonacci().take(4).toList().toString() eq
            "[0, 1, 1, 2]"

    fibonacci().take(10).toList().toString() eq
            "[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]"
}