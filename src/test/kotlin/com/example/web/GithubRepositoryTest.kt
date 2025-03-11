package com.example.web

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class GithubRepositoryTest {

    @Autowired
    private lateinit var githubRepository: GithubRepository

    @Test
    fun getRepo() {
        val repo = githubRepository.getRepo("xyzker/kotlin-gradle-spring-boot-demo")
        println(repo)
    }
}