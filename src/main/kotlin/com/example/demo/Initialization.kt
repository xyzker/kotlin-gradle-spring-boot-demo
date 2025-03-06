package com.example.demo

open class P(open val value: String) {
    init {
        // 使用 value 属性，当 value 为 null 时会抛出 NPE
        println(value.length)
    }
}

class C(override val value: String) : P(value)

fun main(args: Array<String>) {
    C("a")
}