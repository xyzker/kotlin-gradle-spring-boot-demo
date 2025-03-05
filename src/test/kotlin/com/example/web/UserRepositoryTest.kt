package com.example.web

import com.example.TestcontainersConfig
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Commit
import org.springframework.test.context.TestPropertySource
import javax.sql.DataSource

@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest : TestcontainersConfig() {

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var dataSource: DataSource

    @Test
    @Commit
    fun `should save and retrieve user`() {
        // 保存用户
        val savedUser = userRepository.save(User(name = "Test", email = "test@example.com"))

        println(dataSource.connection.metaData.url);
        // 验证查询
        val foundUser = userRepository.findById(savedUser.id!!)
        assertTrue(foundUser.isPresent)
        assertEquals("Test", foundUser.get().name)
    }

    @Test
    fun `should find all users`() {
        // 初始化数据
        userRepository.saveAll(listOf(
            User(name = "User1", email = "user1@example.com"),
            User(name = "User2", email = "user2@example.com")
        ))

        // 验证总数
        val users = userRepository.findAll()
        assertEquals(2, users.size)
    }
}