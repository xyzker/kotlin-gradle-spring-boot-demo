package com.example.web

import jakarta.persistence.*

@Entity
@Table(name = "app_user")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String = "",  // 添加默认值
    val email: String = ""  // 添加默认值
) {
    constructor() : this(null) // 显式添加无参构造函数
}
