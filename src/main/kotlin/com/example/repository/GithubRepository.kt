package com.example.repository

import org.kohsuke.github.*
import org.springframework.stereotype.Repository
import java.io.FileNotFoundException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption
import java.nio.file.StandardOpenOption
import java.util.*

@Repository
class GithubRepository (
    val github: GitHub
){
    fun getRepo(name: String) : GHRepository = github.getRepository(name)

    fun getLatestCommitId(gHRepository: GHRepository) : String {
        // 获取 main 分支的最新 commit ID
        return gHRepository.getBranch("main").shA1
    }

    /**
     * 下载指定路径下的所有文件到本地目标目录
     */
    fun downloadFiles(gHRepository: GHRepository, commitId: String, path: String,
                      subPath: String) {
        val commit = gHRepository.getCommit(commitId)
        val rootTree = commit.tree
        val downloadPath = System.getProperty("user.dir") + "/download" + "/" + gHRepository.name +
                "/" + commitId + "/" + subPath
        val targetDir = Path.of(downloadPath)

        // 创建目标目录（如果不存在）
        Files.createDirectories(targetDir)

        rootTree.findEntry(path).takeIf { it != null }?.let { entry ->
            processTreeEntry(entry, targetDir)
        } ?: throw FileNotFoundException("Path '$path' not found in commit $commitId")
    }

    private fun GHTree.findEntry(path: String): GHTreeEntry? {
        var currentTree = this
        return path.split('/').filter { it.isNotEmpty() }.fold(null as GHTreeEntry?) { entry, part ->
            entry?.takeIf { it.type == "tree" }?.asTree()?.let { currentTree = it }
            currentTree.tree.firstOrNull { it.path == part }
        }
    }

    private fun processTreeEntry(entry: GHTreeEntry, parentDir: Path) {
        when (entry.type) {
            "blob" -> downloadFile(entry, entry.asBlob(), parentDir)
            "tree" -> processTree(entry.asTree(), parentDir)
        }
    }

    private fun processTree(tree: GHTree, parentDir: Path) {
        tree.tree.forEach { entry ->
            processTreeEntry(entry, parentDir)
        }
    }

    private fun downloadFile(entry: GHTreeEntry, blob: GHBlob, parentDir: Path) {
        // 从 tree entry 获取文件路径
        val filePath = parentDir.resolve(entry.path.substringAfterLast('/'))
        // 覆盖已存在文件
        Files.writeString(filePath, blob.content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)
    }
}