package com.example.demo

fun main() {
    // 初始化MutableMap
    val map = mutableMapOf<Int, List<String>>()
    val list = listOf<String>()
    list.groupingBy { it.length  }.eachCount()
}

/*fun main() {
    val numbers = sequence {
        var x = 0
        while (true) {
            yield(x++)
        }
    }
    numbers.take(5).toList()
    // [0, 1, 2, 3, 4]
}*/
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
/*
fun main(){
    */
/*println(listOf('a', 'b', 'c').joinToString(
        separator = "", prefix = "(", postfix = ")"))*//*

    val numbers = generateSequence(3) { n ->
        println("Generating element...")
        (n + 1).takeIf { it < 7 }
    }
    println(numbers.first())
}
*/
