package com.example.demo

var count = 0

val foo: Int
    get() = count++

fun main(args: Array<String>) {
    // The values should be different:
    println(foo)
    println(foo)
    println(foo)
}