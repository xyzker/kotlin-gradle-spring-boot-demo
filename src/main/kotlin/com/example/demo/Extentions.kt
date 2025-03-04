package com.example.demo

import org.springframework.util.Assert

/*fun main() {
    val set = hashSetOf(1, 7, 53)
    val list = arrayListOf("one", "seven", "fifty-three")
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)
}*/

fun String?.isEmptyOrNull() = this == null || this.isEmpty();

infix fun Boolean.eq(b: Boolean): Boolean {
    return this == b
}

fun main(args: Array<String>) {
    val s1: String? = null
    val s2: String? = ""
    println(s1.isEmptyOrNull() eq true)
    println(s2.isEmptyOrNull() eq true)

    val s3 = "   "
    println(s3.isEmptyOrNull() eq false)
}



