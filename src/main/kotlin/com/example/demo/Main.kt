package com.example.demo

/*fun main() {
    val name = "Kotlin";
    println("Hello, $name!");
}*/

/*
fun main(args: Array<String>) {
    val name = if (args.size > 0) args[0] else "Kotlin"
    println("Hello, $name!")
    println("Hello, ${args.getOrNull(0)}!")
}*/
fun main(){
    println(listOf('a', 'b', 'c').joinToString(
        separator = "", prefix = "(", postfix = ")"))
}
