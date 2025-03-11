package com.example.web

import org.kohsuke.github.GHRepository
import org.kohsuke.github.GitHub
import org.springframework.stereotype.Repository

@Repository
class GithubRepository (
    val github: GitHub
){
    fun getRepo(name: String) : GHRepository = github.getRepository(name)
}