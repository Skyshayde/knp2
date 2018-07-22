package com.github.skyshayde.models.message

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Message (
        val status: String,
        val group: String,
        val created: String,
        val comment_count: Int,
        val key: String,
        val activity: String,
        val payload: Map<String, String>
)