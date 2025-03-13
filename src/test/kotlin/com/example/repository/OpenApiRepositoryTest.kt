package com.example.repository

import com.example.config.BeanConfig
import io.swagger.v3.oas.models.OpenAPI
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
        OpenApiRepository::class,
        BeanConfig::class
    ]
)
@EnableAutoConfiguration(exclude = [
    DataSourceAutoConfiguration::class,
    DataSourceTransactionManagerAutoConfiguration::class,
    HibernateJpaAutoConfiguration::class
])
@ActiveProfiles("dev")
class OpenApiRepositoryTest {

    @Autowired
    private lateinit var openApiRepository: OpenApiRepository

    val filePath = "testservice/v1.yml"

    @Test
    fun readOpenApi() {
        val openAPi = openApiRepository.parseOpenApiFile(filePath)
        println(openAPi)
    }

}