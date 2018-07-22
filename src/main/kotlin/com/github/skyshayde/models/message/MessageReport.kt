package com.github.skyshayde.models.message

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class MessageReport (
        val event: String,
        val report: Messages
)