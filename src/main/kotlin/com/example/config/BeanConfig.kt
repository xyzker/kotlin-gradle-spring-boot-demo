package com.example.config

import org.kohsuke.github.GitHub
import org.kohsuke.github.GitHubBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfig (
    @Value("\${github.token}")
    val token: String
) {
    @Bean
    fun github() : GitHub = GitHubBuilder().withOAuthToken(token).build()
}