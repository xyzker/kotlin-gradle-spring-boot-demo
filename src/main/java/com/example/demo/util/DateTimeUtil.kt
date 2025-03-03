package com.example.demo.util

import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

object DateTimeUtil {
    private val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

    /**
     * 获取当前时间的格式化字符串
     */
    fun currentFormattedTime(): String {
        return LocalDateTime.now().format(formatter)
    }

    /**
     * 将时间戳转换为格式化的日期字符串
     * @param timestamp 毫秒时间戳
     */
    fun formatTimestamp(timestamp: Long): String {
        val dateTime = LocalDateTime.ofEpochSecond(
            timestamp / 1000,
            0,
            ZoneOffset.ofHours(8)
        )
        return dateTime.format(formatter)
    }
}