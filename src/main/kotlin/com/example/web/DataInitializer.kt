package com.example.web

import com.example.web.User
import com.example.web.UserRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

@Component
class DataInitializer(
    private val userRepository: UserRepository
) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        userRepository.saveAll(listOf(
            User(name = "张三", email = "zhangsan@example.com"),
            User(name = "李四", email = "lisi@example.com"),
            User(name = "王五", email = "wangwu@example.com")
        ))
    }
}