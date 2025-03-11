package com.example.web

import com.example.KotlinGradleSpringBootDemoApplication
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(
    classes = [KotlinGradleSpringBootDemoApplication::class],
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureWebTestClient
class DemoControllerTest {

    @Autowired
    lateinit var client: WebTestClient

    @Test
    fun testHello() {
        client.get()
           .uri("/api/hello/John")
           .exchange()
           .expectStatus().isOk
           .expectBody()
           .jsonPath("$.message").isEqualTo("你好, John!")
    }
}
