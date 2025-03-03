package com.example.web

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class DemoController (
    private val userRepository: UserRepository
){
    // 带路径参数的GET请求
    @GetMapping("/hello/{name}")
    fun hello(@PathVariable name: String): Map<String, String> {
        return mapOf("message" to "你好, $name!")
    }

    // 处理POST请求并返回JSON
    @PostMapping("/data")
    fun processData(@RequestBody request: HelloRequest): HelloResponse {
        return HelloResponse(
            original = request,
            processed = "已处理: ${request.content}"
        )
    }

    // 带查询参数的GET请求
    @GetMapping("/search")
    fun search(@RequestParam("q") query: String?): List<String> {
        return listOf("结果1", "结果2").filter {
            query?.let { q -> it.contains(q) } ?: true
        }
    }

    @PostMapping("/users")
    fun createUser(@RequestBody user: User): User {
        return userRepository.save(user)
    }

    @GetMapping("/users")
    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }
}

// 请求体数据类
data class HelloRequest(
    val id: Long,
    val content: String
)

// 响应体数据类
data class HelloResponse(
    val original: HelloRequest,
    val processed: String
)