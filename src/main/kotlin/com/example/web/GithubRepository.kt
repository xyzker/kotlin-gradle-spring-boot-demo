package com.example.web

import org.kohsuke.github.GitHub
import org.springframework.stereotype.Repository

@Repository
class GithubRepository (
    val github: GitHub
){
    fun getRepo(name: String) = github.getRepository(name)
}