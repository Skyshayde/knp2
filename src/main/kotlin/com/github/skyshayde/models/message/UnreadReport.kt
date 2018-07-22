package com.github.skyshayde.models.message

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UnreadReport (
        val event: String,
        val report: Map<String, Int>
)