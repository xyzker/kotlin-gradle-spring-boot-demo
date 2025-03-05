package com.example

import org.junit.jupiter.api.BeforeAll
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.GenericContainer
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.images.builder.ImageFromDockerfile
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import java.nio.file.Paths

val POSTGRES_DB = "testdb"
val POSTGRES_USER = "test"
val POSTGRES_PASSWORD = "test"

@Testcontainers
abstract class TestcontainersConfig {
    
    companion object {
        @Container
        private val postgresContainer = PostgreSQLContainer("postgres:16.0")
            .withDatabaseName(POSTGRES_DB)
            .withUsername(POSTGRES_USER)
            .withPassword(POSTGRES_PASSWORD)

/*        companion object {
            @Container
            private val postgresContainer = GenericContainer<Nothing>(
                ImageFromDockerfile()
                    .withDockerfile(Paths.get("docker/postgresDockerFile"))
                 .withDockerfileFromBuilder { builder ->
                     builder.env("POSTGRES_DB", POSTGRES_DB)
                         .env("POSTGRES_USER", POSTGRES_USER)
                         .env("POSTGRES_PASSWORD", POSTGRES_PASSWORD)

                 }
            ).apply {
                withExposedPorts(5432)
            }*/

        @JvmStatic
        @DynamicPropertySource
        fun registerProperties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url") { postgresContainer.jdbcUrl  }
            registry.add("spring.datasource.username") { POSTGRES_USER }
            registry.add("spring.datasource.password") { POSTGRES_PASSWORD }
        }

        @BeforeAll
        @JvmStatic
        fun beforeAll() {
            postgresContainer.start()
        }
    }
}
