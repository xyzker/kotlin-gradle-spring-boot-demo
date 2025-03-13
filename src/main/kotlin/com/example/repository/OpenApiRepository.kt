package com.example.repository

import com.fasterxml.jackson.databind.ObjectMapper
import io.swagger.v3.oas.models.OpenAPI
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.core.io.ResourceLoader
import org.springframework.stereotype.Repository
import java.io.InputStreamReader

@Repository
class OpenApiRepository(
    val resourceLoader: ResourceLoader,
    @Qualifier("yamlMapper")
    val yamlMapper : ObjectMapper
) {

    fun parseOpenApiFile(filePath: String): OpenAPI {
        val parentPath = System.getProperty("user.dir") + "/input/openapi/"
        val path = parentPath + filePath
        // 使用文件系统绝对路径（添加 file: 协议前缀）
        val resource = resourceLoader.getResource("file:$path")
            .takeIf { it.exists() && it.isReadable }
            ?: throw IllegalArgumentException("OpenAPI file not found: $path")

        return resource.inputStream.use { inputStream ->
            yamlMapper.readValue(InputStreamReader(inputStream), OpenAPI::class.java)
        }
    }

    fun parseOpenApiContent(yamlContent: String): OpenAPI {
        return yamlMapper.readValue(yamlContent, OpenAPI::class.java)
    }
}
