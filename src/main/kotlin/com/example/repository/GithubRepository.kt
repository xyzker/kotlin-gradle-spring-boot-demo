package com.example.repository

import org.kohsuke.github.GHRepository
import org.kohsuke.github.GitHub
import org.springframework.stereotype.Repository

@Repository
class GithubRepository (
    val github: GitHub
){
    fun getRepo(name: String) : GHRepository = github.getRepository(name)

    fun getLatestCommitId(name: String) : String {
        val gHRepository = getRepo(name)
        // 获取 main 分支的最新 commit ID
        return gHRepository.getBranch("main").shA1
    }
}