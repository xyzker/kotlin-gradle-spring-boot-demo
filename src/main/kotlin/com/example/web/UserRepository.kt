package com.example.web

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>