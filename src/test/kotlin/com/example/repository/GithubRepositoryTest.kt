package com.example.repository

import com.example.config.BeanConfig
import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(
    classes = [
        GithubRepository::class,
        BeanConfig::class
    ]
)
@EnableAutoConfiguration(exclude = [
    DataSourceAutoConfiguration::class,
    DataSourceTransactionManagerAutoConfiguration::class,
    HibernateJpaAutoConfiguration::class
])
@ActiveProfiles("dev")
class GithubRepositoryTest {

    @Autowired
    private lateinit var githubRepository: GithubRepository

    val repoName = "xyzker/kotlin-gradle-spring-boot-demo"

    @Test
    fun getRepo() {
        val repo = githubRepository.getRepo(repoName)
        println(repo)
    }

    @Test
    fun getLatestCommitId() {
        val repo = githubRepository.getRepo(repoName)
        val commitId = githubRepository.getLatestCommitId(repo)
        println(commitId)
    }
}