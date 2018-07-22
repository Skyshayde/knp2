package com.github.skyshayde.models.message

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Messages (
        val messages: List<Message>,
        val group: String
)