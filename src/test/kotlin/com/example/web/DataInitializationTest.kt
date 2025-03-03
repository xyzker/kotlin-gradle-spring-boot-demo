package com.example.web

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
class DataInitializationTest {

    @Autowired
    private lateinit var userRepository: UserRepository


    @Test
    fun init() {
        userRepository.saveAll(listOf(
            User(name = "张三", email = "zhangsan@example.com"),
            User(name = "李四", email = "lisi@example.com"),
            User(name = "王五", email = "wangwu@example.com")
        ))
    }
}
